FROM maven:3.8-openjdk-17 AS build

WORKDIR /usr/src/app

COPY pom.xml .
COPY src ./src

RUN mvn package 

FROM openjdk:21-slim

COPY --from=build /usr/src/app/target/composite-api-demo-0.0.1-SNAPSHOT.jar /usr/app/composite-api-demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "/usr/app/composite-api-demo-0.0.1-SNAPSHOT.jar" ]