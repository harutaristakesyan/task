FROM openjdk:17-jdk-slim

WORKDIR /usr/src/app

COPY . /usr/src/app
RUN chmod +x ./gradlew
RUN sh gradlew clean bootJar -x test
RUN cp build/libs/*.jar i18n.jar

CMD [ "java", "-jar", "i18n.jar" ]
