FROM openjdk:21
ARG JAR_FILE=target/*.jar
COPY ./target/push_notifications-0.0.1-SNAPSHOT.jar app.jar
LABEL authors="Juan-Fruto"

ENTRYPOINT ["java", "-jar", "/app.jar"]