FROM openjdk:17-jdk-slim

WORKDIR /file-management-backend

COPY build/libs/*.jar file-management-backend.jar

CMD [ "java", "-jar", "file-management-backend.jar" ]
