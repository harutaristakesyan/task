FROM openjdk:17-jdk-slim

WORKDIR /configuration-backend

COPY build/libs/*.jar configuration-backend.jar

CMD [ "java", "-jar", "configuration-backend.jar" ]
