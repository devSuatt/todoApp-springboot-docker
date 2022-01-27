FROM openjdk:11 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:11
WORKDIR todoapp
COPY --from=build target/*.jar todoapp.jar
ENTRYPOINT ["java", "-jar", "todoapp.jar"]