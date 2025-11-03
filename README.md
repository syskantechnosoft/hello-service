# hello-service

Simple Spring Boot example that supports multiple databases via profiles and includes Docker, docker-compose, Kubernetes manifests, and a GitHub Actions pipeline that builds and pushes a Docker image.

Features
- Spring Boot 3, Java 17
- Profiles and placeholders for MS SQL, Postgres, MongoDB, Redis, Cassandra, Supabase, H2
- Global exception handling
- Tests with Jacoco coverage enforcement (95%)
- Dockerfile and docker-compose for local development
- Kubernetes manifests
- GitHub Actions workflow to build, test, and push Docker image to Docker Hub

Run locally (Maven required):

mvn -B -DtrimStackTrace=false clean verify

mvn -B -DskipTests=false -DtrimStackTrace=false test

mvn -B test -DtrimStackTrace=false -DfailIfNoTests=false -DskipTests=false

mvn clean verify -Djacoco.skip=true

1) Start DBs with docker-compose

   docker-compose up -d

2) Build and run

   mvn -B clean package
   docker build -t youruser/hello-service:local .
   docker run -p 8085:8085 youruser/hello-service:local

Endpoints
- GET /api/hello -> returns greeting

CI/CD
Set secrets: DOCKERHUB_USERNAME and DOCKERHUB_TOKEN in GitHub repository settings for the workflow to push images.
