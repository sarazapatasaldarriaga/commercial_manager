output "s3_bucket_name" {
  description = "The name of the S3 bucket."
  value       = aws_s3_bucket.main.bucket
}

output "s3_bucket_website_endpoint" {
  description = "The website endpoint of the S3 bucket."
  value       = aws_s3_bucket_website_configuration.main.website_endpoint
}
