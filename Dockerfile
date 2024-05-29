FROM openjdk:21
ARG JAR_FILE=target/*.jar

COPY env_jar_config.sh /
COPY .env /
COPY ./target/push_notifications-0.0.1-SNAPSHOT.jar app.jar

LABEL authors="Juan-Fruto"

RUN chmod +x /env_jar_config.sh

ENTRYPOINT ["/env_jar_config.sh"]
#ENTRYPOINT ["java", "-jar", "/app.jar"]

