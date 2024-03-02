# Use the official OpenJDK image with Java 17 as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/bmi-calculator-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port that your Spring Boot app runs on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]


