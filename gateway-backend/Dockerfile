FROM openjdk:17-jdk-slim

WORKDIR /gateway-backend

COPY build/libs/*.jar gateway-backend.jar

CMD [ "java", "-jar", "gateway-backend.jar" ]
