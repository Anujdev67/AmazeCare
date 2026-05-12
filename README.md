# AmazeCare

AmazeCare is a Spring Boot based hospital management backend.

## Run locally

1. Ensure MySQL is running.
2. Start the app:

```bash
./mvnw spring-boot:run
```

The application reads database and server settings from environment variables, with safe local defaults.

## Run with Docker (cloud-ready setup)

This repository includes a production-friendly `Dockerfile` and a `docker-compose.yml` stack.

```bash
docker compose up --build
```

Services started:
- `amazecare-app` on `http://localhost:8082`
- `amazecare-mysql` on `localhost:3306`

## Environment variables

- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`
- `SERVER_PORT`
- `JPA_DDL_AUTO`
