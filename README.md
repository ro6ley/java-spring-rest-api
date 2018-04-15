# Java REST API

A RESTful CRUD API for a simple Note-taking application using Spring Boot, MySQL, JPA and Hibernate.

## Requirements
- Java 1.8.x
- Maven 3.x.x
- MySQL 5.x.x

## Setup

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/callicoder/spring-boot-mysql-rest-api-tutorial.git
```

**2. Create Mysql database**
```bash
create database notes_app
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/easy-notes-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore the routes

The app defines following routes.

   - GET /api/notes
    
   - POST /api/notes
    
   - GET /api/notes/{noteId}
    
   - PUT /api/notes/{noteId}
    
   - DELETE /api/notes/{noteId}
