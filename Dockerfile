# syntax=docker/dockerfile:1

# Build stage: compiles the Spring Boot application into a runnable jar.
FROM eclipse-temurin:21-jdk AS build
WORKDIR /workspace

COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw && ./mvnw -q -DskipTests dependency:go-offline

COPY src src
RUN ./mvnw -q -DskipTests package

# Runtime stage: lightweight image used in local and cloud environments.
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /workspace/target/*.jar app.jar

EXPOSE 8082
ENTRYPOINT ["java","-jar","/app/app.jar"]
