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

variable "db_driver_class_name" {
  description = "The JDBC driver class name for the database."
  type        = string
}

variable "front_endpoint" {
  description = "The URL of the frontend for CORS configuration."
  type        = string
}
