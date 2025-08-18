terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 6.0" # Use a compatible version
    }
    random = {
      source  = "hashicorp/random"
      version = "~> 3.1"
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
  default     = "us-east-2" # Set your desired default region
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
  default     = 8081
}

variable "container_name" {
  description = "The name of the container."
  type        = string
  default     = "commercial-manager-container"
}

variable "health_check_path" {
  description = "The health check path for the target group."
  type        = string
  default     = "/"
}

variable "front_endpoint" {
  description = "S3 URL for Cross-origin permission"
  type        = string
  default     = ""
}

variable "db_endpoint" {
  description = "The endpoint of the database."
  type        = string
}

variable "db_port" {
  description = "The port of the database."
  type        = number
}

variable "db_name" {
  description = "The name of the database."
  type        = string
}

variable "db_username" {
  description = "The username for the database."
  type        = string
}

variable "db_password" {
  description = "The password for the database."
  type        = string
  sensitive   = true
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

data "aws_subnets" "public" {
  filter {
    name   = "vpc-id"
    values = [data.aws_vpc.default.id]
  }
  filter {
    name   = "map-public-ip-on-launch"
    values = ["true"]
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

# ALB Module
module "alb" {
  source = "./modules/alb"

  project_name      = var.project_name
  vpc_id            = data.aws_vpc.default.id
  public_subnets    = data.aws_subnets.public.ids
  target_port       = var.container_port
  health_check_path = var.health_check_path
}

# ECS Module
module "ecs" {
  source = "./modules/ecs"

  project_name         = var.project_name
  aws_region           = var.aws_region
  vpc_id               = data.aws_vpc.default.id
  private_subnets      = data.aws_subnets.private.ids
  container_port       = var.container_port
  container_name       = var.container_name
  ecr_repository_url   = module.ecr.repository_url
  target_group_arn     = module.alb.target_group_arn
  alb_security_group_id = module.alb.alb_security_group_id
  db_endpoint          = var.db_endpoint
  db_port              = var.db_port
  db_name              = var.db_name
  db_username          = var.db_username
  db_password          = var.db_password
  front_endpoint       = var.front_endpoint
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

output "alb_dns_name" {
  description = "The DNS name of the Application Load Balancer."
  value       = module.alb.alb_dns_name
}

output "alb_url" {
  description = "The URL of the Application Load Balancer."
  value       = "http://${module.alb.alb_dns_name}"
}