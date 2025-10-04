# Use official OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Package the Spring Boot app
RUN apt-get update && apt-get install -y maven && mvn clean package -DskipTests

# Run the jar file
CMD ["java", "-jar", "target/NASA-Hackathon-2025-A-Cube-0.0.1-SNAPSHOT.jar"]
