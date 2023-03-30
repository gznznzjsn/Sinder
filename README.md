# Sinder

## RESTful Spring Boot Application

### Description

Sinder is a dating application with additional logic for party organization.
Main possibilities are:

- Creation of `Pair` profile and `Party` profile.
- Looking through suggested `Pairs`.
- Acceptance or Rejection of suggested `Pairs`.
- Messaging with approved `Pair`.
- Creation of `Party` event.
- Looking through suggested `Parties` or `Guests`.
- Acceptance or Rejection of suggested `Parties` or `Guests`.

### Technologies

- **PostgreSQL** as a database.
- **Liquibase** for managing database changes.
- **Spring Data JPA** is used for communication with database and mapping of models.
- **MinIO** stores images.
- **MapStruct** helps to map DTOs to entities and vice versa.
- **OpenAPI** generates documentation for `Controllers` and their endpoints.
- **Spring Security** and **JWT** tokens provide authentication and authorization.
- **nginx** enables reverse proxying.
- **Docker** is used to create an image of a Spring Boot application.
- **Docker Compose** runs database container and main application container.

### How to run

- With Docker Compose

1. Clone project: `git clone https://github.com/gznznzjsn/Sinder`
2. Go to project folder and package it: `mvn clean install`
3. Create `.env` file and fulfill it.
4. Start application: `docker compose up`
5. Open **Swagger**: http://localhost/sinder/v1/swagger-ui/index.html
6. Feel free to use!
