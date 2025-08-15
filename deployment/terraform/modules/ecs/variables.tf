variable "project_name" {
  description = "The name of the project."
  type        = string
}

variable "aws_region" {
  description = "The AWS region."
  type        = string
}

variable "vpc_id" {
  description = "The ID of the VPC."
  type        = string
}

variable "private_subnets" {
  description = "A list of private subnets for the ECS service."
  type        = list(string)
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

variable "ecr_repository_url" {
  description = "The URL of the ECR repository."
  type        = string
}

variable "target_group_arn" {
  description = "The ARN of the target group for the load balancer."
  type        = string
}

variable "alb_security_group_id" {
  description = "The security group ID of the ALB."
  type        = string
}
