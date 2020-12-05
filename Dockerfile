FROM openjdk:14.0.2-jdk

LABEL maintainer="Zaira Oliveira <zfeitosa9@gmail.com>"

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080/tcp

ENTRYPOINT ["java","-jar","/app.jar"]