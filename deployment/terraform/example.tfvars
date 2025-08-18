# # AWS region for deployment.
# # Default: "us-east-2"
# aws_region = "us-east-2"

# # Project name for resource naming.
# # Default: "commercial-manager"
# project_name = "commercial-manager"

# ------------------------------------------------------------------------------
# CodePipeline Configuration
# ------------------------------------------------------------------------------

# # GitHub repository owner and name for the source code.
# default = "sarazapatasaldarriaga/commercial_manager"
# github_repo_owner_name = "sarazapatasaldarriaga/commercial_manager"

# # Branch of the GitHub repository to monitor for CI/CD changes
# default = "main"
# github_branch_name = "main"

# The ARN of the AWS CodeStar Connection to GitHub.
# codestar_connection_arn = "arn:aws:codeconnections:xxx"

# # The port your application container listens on
# default = 8081
# container_port = 8081

# ------------------------------------------------------------------------------
# DB Connection Configuration 
# ------------------------------------------------------------------------------

# # (Required) DB endpoint
# # No default value is provided for security reasons. You must set this.
# db_endpoint = "xxx.rds.amazonaws.com"

# # DB port
# # default = 3306
# db_port = 3306

# # DB name
# default = "commercial_manager"
# db_name = "commercial_manager"

# # DB username
# # default = "admin"
# db_username = "admin"

# # (Required) DB password
# # No default value is provided for security reasons. You must set this.
# db_password = "YourSecurePasswordHere123!"

# ------------------------------------------------------------------------------
# Frontend Connection Configuration 
# ------------------------------------------------------------------------------
# # (Required) S3 URL for Cross-origin permission
# # No default value is provided for security reasons. You must set this.
# front_endpoint = "s3://your-bucket-name.com"
