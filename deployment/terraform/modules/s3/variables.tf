variable "project_name" {
  description = "A name for the project, used to prefix resource names."
  type        = string
}

variable "environment" {
  description = "The deployment environment (e.g., 'dev', 'staging', 'prod')."
  type        = string
}
