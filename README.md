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

## Class Diagram
Before starting on the code, we first need to establish our database design.

<img src="assets/class_diag.png" alt="recruitment_class_diag" width="800" height="400">

## Testing the code
To test out the code yourself:
1. Clone the project
``` git clone https://github.com/Cristal32/recruitment_platform.git ```

2. The server will be listening on the port 8080: you can test it out on the URL http://localhost:8080 (GET methods with a browser, for more elaborate testing, you can use Postman)
3. To execute the backend, simply build and run the app in your Java IDE such as Eclipse or IntelliJ
4. To execute the frontend, run this command in a terminal:
``` ng serve ```
Then access the URL: http://localhost:4200
