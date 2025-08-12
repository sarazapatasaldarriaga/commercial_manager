# Stage 1: Build the application using Maven
FROM public.ecr.aws/docker/library/maven:3.9-eclipse-temurin-21 AS builder

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies to leverage Docker layer caching
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Package the application, skipping tests
RUN mvn package -DskipTests

# Stage 2: Create the final, lightweight image
FROM public.ecr.aws/ubuntu/jre:21-24.04_stable

# Set the working directory
WORKDIR /app

# Copy the application JAR from the builder stage
COPY --from=builder /app/target/spring-boot-data-Supplier-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8081

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
