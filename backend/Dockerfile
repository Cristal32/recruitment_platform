# Use official OpenJDK image as base
FROM openjdk:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy Maven executable to the image
COPY mvnw .

# Copy the entire project to the image
COPY . .

# Package the application
RUN ./mvnw package -DskipTests

# Expose the port the app runs on
EXPOSE 8080

# Start the Spring Boot application
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]