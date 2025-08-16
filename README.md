# Commercial Manager API - Documentación Técnica

## 📋 Información General

**Commercial Manager** es una API REST desarrollada en Spring Boot 3 con Java 21 que proporciona funcionalidades para la gestión comercial incluyendo clientes, productos, proveedores y ventas.

### 🔧 Especificaciones Técnicas

- **Framework**: Spring Boot 3.2.5
- **Java Version**: JDK 21
- **Puerto**: 8081 (HTTPS)
- **Base de Datos**: H2 (en memoria) / MySQL
- **SSL**: Habilitado con certificado PKCS12
- **Documentación API**: Swagger UI
- **Containerización**: Docker
- **Infraestructura**: AWS ECS Fargate + ALB

## 🚀 Arquitectura del Sistema

### Arquitectura de la Aplicación

```
┌─────────────────────┐
│   Load Balancer     │ (ALB)
│   Port 80 (HTTP)    │
└──────────┬──────────┘
           │
┌──────────▼──────────┐
│   ECS Fargate       │
│   Port 8081 (HTTPS) │
│   Commercial API    │
└─────────────────────┘
```

### Componentes AWS Desplegados

1. **Application Load Balancer (ALB)**
   - Puerto 80 (HTTP) público
   - Redirige tráfico a ECS en puerto 8081 HTTPS

2. **ECS Cluster Fargate**
   - Contenedores escalables y sin servidor
   - Auto-registro en Target Group

3. **ECR Repository**
   - Almacenamiento de imágenes Docker
   - Integrado con CodePipeline

4. **CodePipeline + CodeBuild**
   - CI/CD automatizado desde GitHub
   - Build de Maven + Docker

## 🏗️ Estructura del Proyecto

```
commercial_manager/
├── src/
│   ├── main/
│   │   ├── java/com/commercial_manager/
│   │   │   ├── CommercialManagerApplication.java
│   │   │   ├── config/
│   │   │   │   ├── SwaggerConfig.java
│   │   │   │   └── WebConfig.java
│   │   │   ├── controllers/
│   │   │   │   ├── ClientController.java
│   │   │   │   ├── ProductController.java
│   │   │   │   ├── SaleController.java
│   │   │   │   └── SupplierController.java
│   │   │   ├── models/
│   │   │   │   ├── entity/
│   │   │   │   └── repository/
│   │   │   └── service/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── keystore.p12
│   └── test/
├── deployment/terraform/
│   ├── main.tf
│   └── modules/
│       ├── alb/
│       ├── ecr/
│       ├── ecs/
│       └── codepipeline/
├── Dockerfile
├── buildspec.yml
└── pom.xml
```

## 🗄️ Modelo de Datos

### Entidades Principales

#### Product
```java
@Entity
@Table(name = "product")
public class Product {
    private Long id;
    private String name;        // @NotEmpty
    private Double price;       // @NotNull
    private Integer stock;      // @NotNull
    private Supplier supplier;  // @ManyToOne
}
```

#### Client
```java
@Entity
@Table(name = "client")
public class Client {
    private Long id;
    private String name;
    private String email;
    private String phone;
    // ... otros campos
}
```

#### Supplier
```java
@Entity
@Table(name = "supplier")
public class Supplier {
    private Long id;
    private String name;
    private String contactInfo;
    // ... otros campos
}
```

## 🔌 API Endpoints

### Base URL
- **Desarrollo**: `https://localhost:8081`
- **Producción**: `http://commercial-manager-alb-<id>.us-east-2.elb.amazonaws.com`

### Products API (`/api/product`)

| Método | Endpoint | Descripción | Estado HTTP |
|--------|----------|-------------|-------------|
| GET | `/list` | Listar todos los productos | 200 |
| GET | `/show/{id}` | Obtener producto por ID | 202 |
| POST | `/save` | Crear nuevo producto | 200 |
| PUT | `/update/{id}` | Actualizar producto | 202 |
| DELETE | `/delete/{id}` | Eliminar producto | 204 |
| GET | `/count` | Contar productos | 200 |

### Clients API (`/api/client`)

| Método | Endpoint | Descripción | Estado HTTP |
|--------|----------|-------------|-------------|
| GET | `/list` | Listar todos los clientes | 200 |
| GET | `/show/{id}` | Obtener cliente por ID | 202 |
| POST | `/save` | Crear nuevo cliente | 200 |
| PUT | `/update/{id}` | Actualizar cliente | 202 |
| DELETE | `/delete/{id}` | Eliminar cliente | 204 |
| GET | `/count` | Contar clientes | 200 |

### Suppliers API (`/api/supplier`)
*Similar estructura a Products y Clients*

### Sales API (`/api/sale`)
*Similar estructura a Products y Clients*

## 🛠️ Configuración y Dependencias

### Dependencias Principales (pom.xml)

```xml
<dependencies>
    <!-- Spring Boot Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <!-- Swagger OpenAPI -->
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.5.0</version>
    </dependency>
    
    <!-- AWS CloudWatch -->
    <dependency>
        <groupId>software.amazon.awssdk</groupId>
        <artifactId>cloudwatch</artifactId>
        <version>2.25.26</version>
    </dependency>
    
    <!-- Base de Datos -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.30</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

### Configuración de la Aplicación

```properties
# Servidor
server.port=8081
spring.application.name=commercial_manager

# Base de Datos H2 (En memoria)
spring.datasource.url=jdbc:h2:mem:commercial_manager
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=admin_commercial_manager
spring.datasource.password=sa

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=none
spring.sql.init.mode=always

# Consola H2
spring.h2.console.enabled=true

# SSL/TLS
server.ssl.key-store=classpath:keystore.p12
server.ssl.key-store-type=PKCS12
server.ssl.key-store-password=samarzasal
server.ssl.key-alias=commercial_manager
```

## 📦 Containerización

### Dockerfile (Multi-stage)

```dockerfile
# Stage 1: Build con Maven
FROM public.ecr.aws/docker/library/maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

# Stage 2: Runtime con JRE
FROM public.ecr.aws/ubuntu/jre:21-24.04_stable
WORKDIR /app
COPY --from=builder /app/target/spring-boot-data-Supplier-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## 🚀 CI/CD Pipeline

### CodeBuild (buildspec.yml)

```yaml
phases:
  install:
    runtime-versions:
      java: corretto21
  
  pre_build:
    commands:
      - echo Logging in to Amazon ECR...
      - aws ecr get-login-password --region $AWS_DEFAULT_REGION | docker login --username AWS --password-stdin $AWS_ACCOUNT_ID.dkr.ecr.$AWS_DEFAULT_REGION.amazonaws.com
  
  build:
    commands:
      - echo Building the Maven project...
      - mvn clean install -DskipTests
      - echo Building Docker image...
      - docker build -t $IMAGE_REPO_NAME:$IMAGE_TAG .
      - docker tag $IMAGE_REPO_NAME:$IMAGE_TAG $REPOSITORY_URI:$IMAGE_TAG
  
  post_build:
    commands:
      - echo Pushing the Docker image to Amazon ECR...
      - docker push $REPOSITORY_URI:$IMAGE_TAG
      - printf '[{"name":"%s","imageUri":"%s"}]' "$CONTAINER_NAME" "$REPOSITORY_URI:$IMAGE_TAG" > imagedefinitions.json
```

### Pipeline Stages

1. **Source**: Conexión con GitHub (branch main)
2. **Build**: CodeBuild ejecuta Maven + Docker
3. **Deploy**: Actualiza ECS Service con nueva imagen

## ☁️ Infraestructura como Código (Terraform)

### Módulos Terraform

#### 1. ECR Repository (`modules/ecr`)
- Repositorio para imágenes Docker
- Política de lifecycle (30 días)

#### 2. Application Load Balancer (`modules/alb`)
- ALB público en puerto 80
- Target Group en puerto 8081 (HTTPS)
- Health checks configurados
- Security Groups

#### 3. ECS Cluster (`modules/ecs`)
- Cluster Fargate
- Service con auto-scaling
- Task Definition
- Integración con ALB

#### 4. CodePipeline (`modules/codepipeline`)
- Pipeline CI/CD
- CodeBuild project
- Roles y permisos IAM
- S3 bucket para artifacts

### Variables de Terraform

```hcl
variable "aws_region" {
  default = "us-east-2"
}

variable "project_name" {
  default = "commercial-manager"
}

variable "container_port" {
  default = 8081
}

variable "github_repo_owner_name" {
  default = "sarazapatasaldarriaga/commercial_manager"
}
```

## 📊 Monitoreo y Métricas

### CloudWatch Integration
- Métricas personalizadas via AWS SDK
- Logs de aplicación centralizados
- Monitoreo de health checks del ALB

### Swagger UI
- Documentación interactiva de la API
- Endpoint: `https://localhost:8081/swagger-ui/index.html`

## 🔒 Seguridad

### SSL/TLS
- Certificado PKCS12 integrado
- Comunicación HTTPS en puerto 8081
- Load Balancer maneja terminación SSL

### Security Groups
- ALB: Puertos 80 y 443 desde Internet
- ECS: Puerto 8081 solo desde ALB
- Egress: Sin restricciones para actualizaciones

## 🚀 Despliegue

### Comandos Terraform

```bash
# Inicializar Terraform
terraform init

# Planificar cambios
terraform plan

# Aplicar infraestructura
terraform apply

# Destruir infraestructura
terraform destroy
```

### URLs de Acceso

- **API**: `http://commercial-manager-alb-<id>.us-east-2.elb.amazonaws.com`
- **CodePipeline**: AWS Console → CodePipeline
- **ECS Console**: AWS Console → ECS → commercial-manager-cluster

## 🧪 Testing

### Maven Tests
```bash
mvn test
mvn clean install -DskipTests
```

### JaCoCo Coverage
- Plugin configurado en pom.xml
- Reportes en `target/site/jacoco/`

## 📝 Notas de Desarrollo

### Ejecutar Localmente

```bash
# Clonar repositorio
git clone <repo-url>

# Compilar y ejecutar
mvn spring-boot:run

# Acceder a la aplicación
curl -k https://localhost:8081/api/product/list
```

### Base de Datos H2
- Consola: `https://localhost:8081/h2-console`
- JDBC URL: `jdbc:h2:mem:commercial_manager`
- Usuario: `admin_commercial_manager`
- Password: `sa`

### Swagger Documentation
- URL: `https://localhost:8081/swagger-ui/index.html`
- Incluye todos los endpoints disponibles
- Testing interactivo de la API

## 🐛 Troubleshooting

### Problemas Comunes

1. **Error 502 Bad Gateway**
   - Verificar que el contenedor esté corriendo en puerto 8081
   - Comprobar health checks del Target Group

2. **SSL Certificate Issues**
   - Verificar keystore.p12 en classpath
   - Confirmar password del certificado

3. **Pipeline Failures**
   - Revisar logs en CodeBuild
   - Verificar permisos IAM
   - Comprobar conectividad con GitHub

### Logs útiles

```bash
# Logs de ECS
aws logs get-log-events --log-group-name "/ecs/commercial-manager-service" --region us-east-2

# Estado del Target Group
aws elbv2 describe-target-health --target-group-arn <arn> --region us-east-2

# Estado del servicio ECS
aws ecs describe-services --cluster commercial-manager-cluster --services commercial-manager-service --region us-east-2
```
