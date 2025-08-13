terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 6.0" # Use a compatible version
    }
  }
}

provider "aws" {
  region = var.aws_region
}

# Define common variables
variable "aws_region" {
  description = "The AWS region to deploy resources into."
  type        = string
  default     = "us-east-1" # Set your desired default region
}

variable "project_name" {
  description = "The name of the project, used for naming resources."
  type        = string
  default     = "commercial-manager" # Set your project name
}

variable "github_repo_owner_name" {
  description = "The full repository ID (e.g., 'owner/repo-name') for the GitHub source."
  type        = string
  default = "sarazapatasaldarriaga/commercial_manager"
}

variable "github_branch_name" {
  description = "The branch of the GitHub repository to monitor for changes."
  type        = string
  default     = "main"
}

variable "codestar_connection_arn" {
  description = "The ARN of the AWS CodeStar Connection to GitHub. (e.g., arn:aws:codestar-connections:REGION:ACCOUNT_ID:connection/YOUR_CONNECTION_ID)"
  type        = string
}

variable "container_port" {
  description = "The port that the container listens on."
  type        = number
  default     = 80
}

variable "container_name" {
  description = "The name of the container."
  type        = string
  default     = "commercial-manager-container"
}

# Data sources for VPC and subnets
data "aws_vpc" "default" {
  default = true
}

data "aws_subnets" "private" {
  filter {
    name   = "vpc-id"
    values = [data.aws_vpc.default.id]
  }
}

# ECR Module
module "ecr" {
  source = "./modules/ecr"

  repository_name = "${var.project_name}-repository"
}

# CodePipeline Module
module "codepipeline" {
  source = "./modules/codepipeline"

  project_name          = var.project_name
  aws_region            = var.aws_region
  ecr_repository_url    = module.ecr.repository_url
  ecr_repository_arn    = module.ecr.repository_arn
  source_repo_name      = var.github_repo_owner_name
  source_repo_branch    = var.github_branch_name
  codestar_connection_arn = var.codestar_connection_arn
  ecs_cluster_name      = module.ecs.cluster_name
  ecs_service_name      = module.ecs.service_name
  container_name        = var.container_name
}

# ECS Module
module "ecs" {
  source = "./modules/ecs"

  project_name       = var.project_name
  aws_region         = var.aws_region
  vpc_id             = data.aws_vpc.default.id
  private_subnets    = data.aws_subnets.private.ids
  container_port     = var.container_port
  container_name     = var.container_name
  ecr_repository_url = module.ecr.repository_url
}

output "ecr_repository_url" {
  description = "The URL of the ECR repository."
  value       = module.ecr.repository_url
}

output "codepipeline_url" {
  description = "The URL of the CodePipeline console."
  value       = module.codepipeline.codepipeline_url
}

output "codebuild_project_name" {
  description = "The name of the CodeBuild project."
  value       = module.codepipeline.codebuild_project_name
}

output "ecs_cluster_name" {
  description = "The name of the ECS cluster."
  value       = module.ecs.cluster_name
}

output "ecs_service_name" {
  description = "The name of the ECS service."
  value       = module.ecs.service_name
}
