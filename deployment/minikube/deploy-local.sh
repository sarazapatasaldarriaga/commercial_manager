#!/bin/bash

echo "Building Docker image 'commercial-manager:latest' using minikube build..."
minikube build -t commercial-manager:latest ../../Dockerfile

echo "Applying Kubernetes ConfigMap..."
kubectl apply -f configmap.yaml

echo "Applying Kubernetes Deployment..."
kubectl apply -f deployment.yaml

echo "Applying Kubernetes Service..."
kubectl apply -f service.yaml

echo "Opening Swagger UI in your browser..."
minikube service commercial-manager-service-dev
