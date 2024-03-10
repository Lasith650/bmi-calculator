# Use the official OpenJDK image with Java 17 as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/bmi-calculator-0.0.1-SNAPSHOT.jar /app/app.jar

# Create a non-root user with a user ID between 10000 and 20000
RUN adduser --system --group --uid 15000 nonrootuser

# Give ownership of the /app directory to the non-root user
RUN chown -R nonrootuser /app

# Expose the port that your Spring Boot app runs on
EXPOSE 8080

# Switch to the non-root user
USER nonrootuser

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]
