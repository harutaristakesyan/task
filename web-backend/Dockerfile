FROM openjdk:17-jdk-slim

WORKDIR /web-backend

COPY build/libs/*.jar web-backend.jar

CMD [ "java", "-jar", "web-backend.jar" ]
