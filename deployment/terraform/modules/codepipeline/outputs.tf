output "codepipeline_url" {
  description = "The URL of the CodePipeline console."
  value       = "https://${var.aws_region}.console.aws.amazon.com/codesuite/codepipeline/pipelines/${aws_codepipeline.app_pipeline.name}/view?region=${var.aws_region}"
}

output "codebuild_project_name" {
  description = "The name of the CodeBuild project."
  value       = aws_codebuild_project.app_build.name
}
