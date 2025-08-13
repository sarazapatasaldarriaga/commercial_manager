variable "project_name" {
  description = "The name of the project, used for naming resources."
  type        = string
}

variable "aws_region" {
  description = "The AWS region to deploy resources into."
  type        = string
}

variable "ecr_repository_url" {
  description = "The URL of the ECR repository to push images to."
  type        = string
}

variable "ecr_repository_arn" {
  description = "The ARN of the ECR repository to push images to."
  type        = string
}

variable "source_repo_name" {
  description = "The full repository ID (e.g., 'owner/repo-name') for the GitHub source."
  type        = string
  default     = "sarazapatasaldarriaga/commercial_manager"
}

variable "source_repo_branch" {
  description = "The branch of the source repository to monitor for changes."
  type        = string
  default     = "main"
}

variable "codestar_connection_arn" {
  description = "The ARN of the AWS CodeStar Connection to GitHub."
  type        = string
}

variable "ecs_cluster_name" {
  description = "The name of the ECS cluster."
  type        = string
}

variable "ecs_service_name" {
  description = "The name of the ECS service."
  type        = string
}

variable "container_name" {
  description = "The name of the container within the ECS task definition."
  type        = string
}
