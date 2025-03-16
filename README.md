# Reading Journal Web Application

## Overview
The Reading Journal Web Application is a web-based platform designed to help users track and review books they have read. It provides an intuitive interface to add, edit, delete and manage book entries while maintaining a structured database.

## Technologies Used
- **Java** (Spring Boot) - Backend development
- **Thymeleaf** - Frontend templating engine
- **MySQL** - Database management
- **PhpMyAdmin** - Database administration
- **Postman** - API testing and validation

## Features
- CRUD operations for book entries (Create, Read, Update, Delete)
- Review system to add personal notes on books like: favourite quotes, image of the book, short review and an overall score
- API endpoints for data exchange
- Responsive UI with Thymeleaf

## Project Structure
The application follows the **Model-View-Controller (MVC)** design pattern to ensure a well-structured and maintainable architecture.

- **Model**: Represents the database entities
- **View**: Frontend templates rendered using Thymeleaf
- **Controller**: Handles user requests and manages data flow between Model and View

## Installation and Setup
### Prerequisites
For the set up of the Spring Boot project, I used the Spring Initializr website.
Ensure you have the following installed:
- Java 17 or later
- PhpMyAdmin 
- MySQL (optional, for database management)
- Postman (optional, for API testing)

### Steps
1. Set up the database in PhpMyAdmin:
```bash
CREATE DATABASE reading_journal;
```
2. Configure database connection in application.properties:
```bash
spring.application.name=reading-journal
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.datasource.url=jdbc:mysql://localhost:3306/readingjournal
spring.datasource.username=root
spring.datasource.password=
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```
3. Access the application at http://localhost:8080

## API Testing with Postman

-Test CRUD operations by sending requests to the available API endpoints.
```bash
# For adding a new book in your journal 
http://localhost:8080/books/create
```
-Ensure smooth data exchange between the frontend and backend.

