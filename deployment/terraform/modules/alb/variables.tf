variable "project_name" {
  description = "The name of the project, used for naming resources."
  type        = string
}

variable "vpc_id" {
  description = "The VPC ID where the load balancer will be created."
  type        = string
}

variable "public_subnets" {
  description = "List of public subnet IDs for the load balancer."
  type        = list(string)
}

variable "target_port" {
  description = "The port that targets are listening on."
  type        = number
  default     = 8081
}

variable "health_check_path" {
  description = "The health check path for the target group."
  type        = string
  default     = "/health"
}

variable "certificate_arn" {
  description = "The ARN of the SSL certificate for HTTPS listener (optional)."
  type        = string
  default     = ""
}
