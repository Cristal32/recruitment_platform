# Recruitment platform
This is a simple project for a web platform that allows recruiters to submit job offers, and for candidates to have access to and apply for job positions. 

**Frameworks used:**
- <span> Backend: Spring Boot 3.2.4 <img alt="Spring" width="30px" style="padding-right:10px;" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" /> , Maven <img alt="Maven" width="30px" style="padding-right:10px;" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/maven/maven-original.svg" />, Java 17  <img alt="Java" width="30px" style="padding-right:10px;" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" /></san>
- <span> Frontend: Angular 16.1.2 <img alt="Spring" width="30px" style="padding-right:10px;" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/angular/angular-original.svg" /></span>

<span> **Server:** Apache web server <img alt="Apache" width="30px" style="padding-right:10px;" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/apache/apache-original.svg" /></span>

<span> **Database:** PostgreSQL <img alt="Apache" width="30px" style="padding-right:10px;" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postgresql/postgresql-original.svg" /></span>

**IDEs:**
- <img align="left" alt="Eclipse" width="30px" style="padding-right:10px;" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/eclipse/eclipse-original.svg" /> Eclipse

- <img align="left" alt="VSCode" width="30px" style="padding-right:10px;" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/vscode/vscode-original.svg" /> VSCode

## Diagrams

* Class Diagram:

<img src="assets/class_diag.png" alt="recruitment class diag" width="800" height="400">

* Global architecture:

<img src="assets/global_architecture.PNG" alt="global architecture" width="700" height="300">

## Content

- [0. Backend application](#0-setup-backend-application)
    - [1. Setup the backend application](#1-setup-the-backend-application)
    - [2. MVC design pattern](#2-mvc-design-pattern)
    - [3. File system](#2-file-system)
- [1. Database connexion & configuration](#1-database-connexion--configuration)
- [2. Frontend application](#2-setup-frontend-application)
    - [1. Setup the frontend application](#1-setup-the-frontend-application)
    - [2. App layout](#2-app-layout)
    - [3. Views](#2-views)

## 0. Backend application

### 1. Setup the backend application

We set up the backend project using [Spring Initializr](https://start.spring.io/), as a Maven project, and Java for the language. 

Add Maven dependencies:
- **Spring Web:** to build our RESTful application using Spring MVC, for a Model-View-Controller design pattern.
- **Spring Data JPA:** to persist data into our database.
- **PostgreSQL Driver:** to allow our Java application to connect to the PostgreSQL database. 

The application will be responding on port 8080.

### 2. MVC design pattern

Each entity of our class diagram will have a number of specific classes and interfaces dedicated to it organised in layers:

- **Model:** represents a data entity.
- **Repository or DAO(Data Access Object):** defines the contract for accessing and manipulating entities in the database.
- **Service Interface:** defines the contract for interacting with entities using CRUD operations and other business logic related to the entity.
- **Service Implementation:** implements the service interface.
- **Controller:** handles HTTP requests related to the entity.

<img src="assets/spring_mvc_layers.png" alt="spring mvc layers" width="800" height="300">

Class diagram of the MVC design pattern for an entity:

<img src="assets/MVC_pattern.png" alt="mvc pattern" width="500" height="400">

### 3. File system

In order to allow candidates to upload their CV, as well as for recruiters to download them, we established a file system. All uploaded files will be stored in a separate folder. 

To configure the path toward that folder, add this line of code in the configuration file `application.properties`:
```
file.upload.directory=/path/to/upload/directory/
```

## 1. Database connexion & configuration

### Setup the database

Create a new Database from pgAdmin.

### Configure connexion to the database

In application.properties:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/DATABASE_NAME
spring.datasource.username=USERNAME
spring.datasource.password=PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=org.postgresql.Driver
```

## 2. Frontend application

### 1. Setup the frontend application

1. Create an Angular project:

``` 
ng new project-name 
```

2. You can run the project using the command:

```
ng serve
```

3. The application will be running on port 4200. To view its interface, simply access the URL: http://localhost:4200

### 2. App layout

The frontend layout is composed of different blocs, following the MVC design pattern as well.

* The code for each interface is contained within a **component**, along with its html, css and ts files.
* Since we're using typescript which is a staticly typed language, we can define in a **model** layer, the different entities already establshed in our backend.  
* We can implement the business logic in a **service** layer, with service classes, where we can call the server with HTTP requests.

App layout:

<img src="assets/app_layout.PNG" alt="app layout" width="800" height="300">

### 3. Views

You can find the different views of the application in the folder `assets/views`

## Trying out the code

To test out the code yourself, clone the project:
``` 
git clone https://github.com/Cristal32/recruitment_platform.git 
```

## Perspectives

This project is unfinished. It still needs a lot more refinement, and we have yet to implement the security aspect by implementing authentication and securing access to all endpoints using the Spring Security dependency. 


