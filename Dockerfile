#FROM gradle:8.3.0-jdk17-alpine as build
#COPY . /home/gradle/src
#WORKDIR /home/gradle/src
#RUN ./gradlew build

FROM eclipse-temurin:17-jre-alpine
RUN mkdir /app
COPY /build/libs/cale-0.0.1-SNAPSHOT.jar /app/spring-boot-application.jar
ENTRYPOINT ["java", "-jar", "/app/spring-boot-application.jar"]

