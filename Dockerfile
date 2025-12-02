# ===== Stage 1: Build the Spring Boot JAR =====
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy Maven descriptor and sources
COPY pom.xml .
COPY src ./src

# Build the JAR (skip tests for faster build)
RUN mvn -B clean package -DskipTests

# ===== Stage 2: Run the application =====
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

