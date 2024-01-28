FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build ComercioFacil2/target/ComercioFacil-1.0-SNAPSHOT.jar monitoria.jar

ENTRYPOINT [ "java", "-jar", "monitoria.jar" ]