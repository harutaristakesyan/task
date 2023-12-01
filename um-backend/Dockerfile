FROM openjdk:17-jdk-slim

WORKDIR /um-backend

COPY build/libs/*.jar um-backend.jar

CMD [ "java", "-jar", "um-backend.jar" ]
