# Use OpenJDK 23 image
FROM openjdk:23-jdk-slim

WORKDIR /app

# Copy Maven wrapper and project files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src ./src

# Make mvnw executable
RUN chmod +x mvnw

# Package the app
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run jar
CMD ["java", "-jar", "target/NASA-Hackathon-2025-A-Cube-0.0.1-SNAPSHOT.jar"]
