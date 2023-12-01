FROM openjdk:17-jdk-slim

WORKDIR /auth-backend

COPY build/libs/*.jar auth-backend.jar

CMD [ "java", "-jar", "auth-backend.jar" ]
