FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/diner-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} diner-service.jar
ENTRYPOINT ["java","-jar","/diner-service.jar", "--server.port=8090"]