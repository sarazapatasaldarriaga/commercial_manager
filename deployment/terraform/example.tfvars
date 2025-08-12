# Example Terraform Variable Definitions
#
# This file provides example values for the Terraform variables used in this project.
# You can copy this file to `terraform.tfvars` (and add `terraform.tfvars` to your .gitignore)
# to provide your actual values, especially for sensitive information like `codestar_connection_arn`.

# AWS Region where resources will be deployed (e.g., "us-east-1", "eu-west-1")
# default = "us-east-1"
# aws_region = "us-east-1"

# Name of the project, used for naming AWS resources
# default = "commercial-manager"
# project_name = "my-commercial-app"

# GitHub repository owner and name (e.g., "your-org/your-repo")
# default = "sarazapatasaldarriaga/commercial_manager"
# github_repo_owner_name = "your-github-user/your-repo-name"

# Branch of the GitHub repository to monitor for CI/CD changes
# default = "main"
# github_branch_name = "main"

# The ARN of the AWS CodeStar Connection to GitHub.
# This is crucial for CodePipeline to connect to your GitHub repository.
# Example: arn:aws:codestar-connections:REGION:ACCOUNT_ID:connection/YOUR_CONNECTION_ID
# This value should be treated as sensitive and ideally stored in `terraform.tfvars`
# which is ignored by Git.
# codestar_connection_arn = "arn:aws:codestar-connections:us-east-1:123456789012:connection/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx"

# The port your application container listens on (e.g., 8080, 3000)
# default = 8081
# container_port = 8081

# The desired name for your application container within the ECS task definition
# default = "commercial-manager-container"
# container_name = "my-app-container"
