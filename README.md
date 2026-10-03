# Job Application Platform – Spring Boot Microservices

A Job Application Platform built using **Java, Spring Boot, PostgreSQL, REST APIs, and Microservices Architecture**.

The project is being developed with a production-oriented approach while learning and implementing real-world backend concepts such as service-to-service communication, Docker, service discovery, API Gateway, Kafka, Redis, and distributed tracing.

---

## Architecture

The application is divided into independent microservices.

```text
                    ┌─────────────────┐
                    │   API Gateway   │
                    └────────┬────────┘
                             │
              ┌──────────────┼──────────────┐
              │              │              │
              ▼              ▼              ▼
       ┌────────────┐ ┌─────────────┐ ┌─────────────┐
       │ Job Service│ │   Company   │ │   Review    │
       │            │ │   Service   │ │   Service   │
       └─────┬──────┘ └──────┬──────┘ └──────┬──────┘
             │               │               │
             ▼               ▼               ▼
         ┌───────┐       ┌──────────┐    ┌──────────┐
         │ jobdb │       │ companydb│    │ reviewdb │
         └───────┘       └──────────┘    └──────────┘# Job_Application_Migration_Microservices

Microservices
Job Service
Responsible for managing job postings.
Features include:
- Create jobs
- Get all jobs
- Get job by ID
- Update jobs
- Delete jobs
- Retrieve company information
- Retrieve company reviews
Company Service
Responsible for managing company information.
Features include:
- Create companies
- Get companies
- Get company by ID
- Update company
- Delete company
Review Service
Responsible for managing company reviews.
Features include:
- Create reviews
- Get reviews by company
- Get review by ID
- Update reviews
Technologies
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- REST APIs
- RestTemplate
- Maven
- Docker
- Docker Compose
- Git
- GitHub
Planned / Learning
- OpenFeign
- Apache Kafka
- Redis
- API Gateway
- Service Discovery
- Distributed Tracing
- Zipkin
- AWS
- CI/CD


Job Service
GET     /jobs
GET     /jobs/{id}
POST    /jobs
PUT     /jobs/{id}
DELETE  /jobs/{id}

Company Service
GET     /company
GET     /company/{id}
POST    /company
PUT     /company/{id}
DELETE  /company/{id}

Review Service
GET     /reviews?companyId={companyId}
GET     /reviews/{reviewId}
POST    /reviews?companyId={companyId}
PUT     /reviews/{reviewId}



Spring Boot
     ↓
PostgreSQL
     ↓
REST APIs
     ↓
JPA / Hibernate
     ↓
Microservices
     ↓
Service-to-Service Communication
     ↓
Docker
     ↓
Docker Compose
     ↓
Service Discovery
     ↓
API Gateway
     ↓
OpenFeign
     ↓
Kafka
     ↓
Redis
     ↓
Distributed Tracing
     ↓
AWS