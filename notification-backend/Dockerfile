FROM openjdk:17-jdk-slim

WORKDIR /notification-backend

COPY build/libs/*.jar notification-backend.jar

CMD [ "java", "-jar", "notification-backend.jar" ]
