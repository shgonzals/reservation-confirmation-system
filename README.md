# Reservation Confirmation System

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.6--SNAPSHOT-brightgreen)](https://spring.io/projects/spring-boot)
[![MongoDB](https://img.shields.io/badge/MongoDB-latest-brightgreen)](https://www.mongodb.com/)
[![Swagger](https://img.shields.io/badge/Swagger-2.2.0-orange)](https://springdoc.org/)

## Overview

Reservation Confirmation System is an API for handling restaurant reservations. It utilizes MongoDB for storing reservation details and Kafka for sending confirmation emails. The project is built with Java 17 and Spring Boot 3.1.6-SNAPSHOT.

## Table of Contents

- [Dependencies](#dependencies)
- [Build and Run](#build-and-run)
- [MongoDB Configuration](#mongodb-configuration)
- [Kafka Configuration](#kafka-configuration)
- [Swagger API Documentation](#swagger-api-documentation)
- [Additional Configuration](#additional-configuration)
- [Contributing](#contributing)
- [License](#license)

## Dependencies

The project uses Maven for dependency management. Here are some key dependencies:

- **Spring Boot Starter Data MongoDB:** For MongoDB integration.
- **Spring Boot Starter Web:** For building web applications.
- **Spring Kafka:** For Kafka integration.
- **Lombok:** A library to reduce boilerplate code.
- **Spring Boot Starter Test:** For testing.
- **Springdoc OpenAPI Starter Web MVC UI:** For Swagger API documentation.
- **Resend Java:** For sending confirmation emails.
- **Jackson Databind and Jackson Datatype JSR310:** For JSON processing with Java 8 Date and Time API.

## Build and Run

Make sure you have Java 17 and Maven installed on your machine.

```bash
# Clone the repository
git clone https://github.com/yourusername/reservation-confirmation-system.git

# Navigate to the project directory
cd reservation-confirmation-system

# Build the project
mvn clean install

# Run the application
java -jar target/reservation-confirmation-system-0.0.1-SNAPSHOT.jar
```

The application will be accessible at http://localhost:8080.

## MongoDB Configuration

The project uses MongoDB as its database. You can configure the MongoDB connection in the docker-compose.yml file. The default credentials are:
- Username: rootuser
- Password: rootpass

To start MongoDB and Mongo Express, run:

```bash
docker-compose up
```

Mongo Express will be accessible at http://localhost:8081.

## Kafka Configuration

Kafka is used for sending confirmation emails. The Kafka configuration can be found in the docker-compose.yml file.

```yaml
kafka:
    # ... (configuration for Kafka)
```

## Swagger API Documentation

The API documentation is generated using Swagger. After starting the application, you can access the Swagger UI at:

```bash
http://localhost:8080/swagger-ui/index.html
```

## Additional Configuration

If you're using an IDE, make sure to add the following VM option to avoid any issues with the latest Java versions:

```bash
--add-opens=java.base/java.time=ALL-UNNAMED
```

## Contributing

If you want to contribute to the project, feel free to fork the repository and submit a pull request.

## License

This project is licensed under the MIT License. Feel free to use, modify, and distribute the code.
