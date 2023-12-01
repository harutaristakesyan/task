FROM openjdk:17-jdk-slim

WORKDIR /admin-backend

COPY build/libs/*.jar admin-backend.jar

CMD [ "java", "-jar", "admin-backend.jar" ]
