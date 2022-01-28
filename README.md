
# Todo app project using Spring Boot in backend

This project provides to CRUD operations for users and users' tasks.

- [x] Java 11
- [x] Spring Boot
- [x] Spring Data
- [x] H2 Database
- [x] Documented on Swagger
- [x] Maven
- [x] Dockerized and published on Docker Hub
- [x] Unit tests using JUnit and Mockito

There are 5 endpoints in user-controller:

![Ekran görüntüsü 2022-01-28 122805](https://user-images.githubusercontent.com/81221395/151521861-630fc30f-6ffe-4ecb-b725-edf00ed91b8d.png)

There are 5 endpoints in task-controller:

![Ekran görüntüsü 2022-01-28 122827](https://user-images.githubusercontent.com/81221395/151521882-88fe53d2-42b6-4a6b-b863-e0716fe166de.png)

## Build Application

To install this application, run the following commands:

```git
git clone https://github.com/devSuatt/todoApp-fullStack.git
```

## Test Application

You can run unit tests in `src/test/java/com/devsuatt/todoApp`

## Run Application with dependencies on Maven

- For maven usage

```xml
$ mvn clean install
$ mvn spring-boot:run
```

#### PORT: 8080

Swagger UI will be run on this url

`http://localhost:${PORT}/swagger-ui.html`

### Docker Build

`docker build --compress --force-rm -t {Docker_Hub_Username}/{Docker_Hub_RepoName}:{Tag} .`

Example: `docker build . -t todoapp:1.0`

Run Docker image locally on a container with a name for the container.

`docker run --name todoapp -d -p 9090:8080 todoapp:1.0`

### Docker Hub

You can pull this application from Docker Hub

Link: https://hub.docker.com/r/devsuatt16/todoapp

`docker pull devsuatt16/todoapp`

