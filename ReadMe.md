# We are coding
- Java 17
- Spring Framework
- Spring Boot
- Spring MVC
- Spring Data
- Spring Rest
- Spring Security

## System Login
> Register
> Login (username+password)
> Authorization (Jwt)

## Lessons Steps
> Spring Framework
> Spring Boot
> Spring MVC
> Spring Data (JPA Hibernate)
> Spring Rest (RestFul ==> Jersey)
> Spring Security

### Reference Documentation
* [GitHub](https://github.com/rouvsen/SpringBootApp2)
* [H2 console](http://localhost:8080/h2-console)
* [Swagger](http://localhost:8080/swagger-ui.html)

## Docker Deployment
```sh
1.Step
$   ./mvnw clean package -DskipTests

2.Step
$   docker-compose up
$   docker ps

## POSTMAN ##
3.Step

//Create (Adding)
http://localhost:8080/docker/v1/create/product

//LIST (GET ALL)
http://localhost:8080/docker/v1/list/product

//FIND (BY ID)
http://localhost:8080/docker/v1/find/product/1