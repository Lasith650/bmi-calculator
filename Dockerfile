# Stage 1: Build stage
FROM maven:3.8-openjdk-17 AS build

WORKDIR /app
COPY . /app

# Explicitly set Maven options to avoid interference with potential proxy settings
RUN mvn clean install -B -DskipTests

# Stage 2: Runtime stage
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/bmi-calculator-0.0.1-SNAPSHOT.jar /app/app.jar

# Create a non-root user with a user ID between 10000 and 20000
RUN adduser --system --group --uid 15000 nonrootuser

# Give ownership of the /app directory to the non-root user
RUN chown -R nonrootuser /app

EXPOSE 8080

USER 15000

CMD ["java", "-jar", "/app/app.jar"]
