# Store management tool #

Spring Boot application for managing products in a store. Includes authentication, role-based authorization, exception handling, logging, unit tests and database persistence.

# Author #
- Mariana Serban
- Email: marianaserban734@gmail.com

# Project Structure #
| Module       | Description                             |
|--------------|-------------------------------------|
| controller   | Exposes REST endpoints                |
| service / service.impl | Contains business logic          |
| repository   | Database access layer (JPA)           |
| dto          | Data transfer objects between layers |
| entity       | Representation of persistent entities|
| mapper       | Conversion between DTO and Entity     |
| exception    | Centralized error handling            |
| security     | Set up Spring Security                |

# Tech stack #
- Java 17
- Spring Boot 3.5.3
- Spring Data JPA
- Spring Security
- MySQL database
- Lombok
- Maven
- JUnit/ Mockito
- SLF4J with Logback

# API Endpoints #
- POST /api/products/ - save product
- GET /api/products/ - get all products
- GET /api/products/{id} - find product by id
- PUT /api/products/{id} - update product by id
- DELETE /api/products/{id} - delete product by id


# Authentication & authorization #
The application uses Spring Security with in-memory user authentication and role-based access control. It defines two users: one with the USER role and one with the ADMIN role.

__In - memory users:__

| Username | Password | ROLE  |
|----------|----------|-------|
| user     | user     | USER  |
| admin    | admin    | ADMIN |

__Access rules:__

| HTTP Method | Path | Access Role   |
|-------------|------|---------------|
| GET         | /**  | USER, ADMIN   |
| POST        | /**  | ADMIN only    |
| PUT         | /**  | ADMIN only    |
| DELETE      | /**  | ADMIN only    |

When a user tries to perform an action without the proper role, a custom JSON response is returned:

{
  "error": "You do not have the necessary role to perform this action."
}


# Error handling and logging #
- the application uses a global exception handler. All error responses follow a common format, making them easy to parse and debug.

{  
  "timestamp": "2025-07-11T13:31:48.6784302",  
  "message": "Product not found with id : '22'",  
  "path": "/api/products/22"  
} 

- all errors are logged: warnings and errors 

# Unit Tests
- basic unit tests are implemented for the service layer (ProductServiceImpl)
- tests cover main business logic, including CRUD operations and error scenarios

# Java 17+ features
- used **__sealed interface__** with multiple **__records__** to model error response

# Best practices
- utilized **Java Streams** for efficient and readable collection processing
- used **Text Blocks** for cleaner multiline string literals

# How to run
1. Clone repo

2. Set up MySQL database
    - make sure you have MySQL Server and MySQL Workbench installed
    - open MySQL Workbench and connect to your local MySQL Server
    - run the following command to create db: *create database store_management;*
      
3. Configure db connection. Update the application.properties file with your credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/store_management  
spring.datasource.username=your_username  
spring.datasource.password=your_password  

4. Run the application
The app will start on http://localhost:8080
Use Postman with basic auth to access endpoints
