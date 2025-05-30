FROM ubuntu:latest AS builder

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y 
COPY . .

RUN apt-get install maven -y
RUN mvn clean install -DskipTests

FROM openjdk:17-slim

EXPOSE 8080

COPY --from=builder /target/crudDeAlunos-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java","-jar","app.jar" ]
