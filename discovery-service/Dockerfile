FROM openjdk:8-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} discovery-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/discovery-service-0.0.1-SNAPSHOT.jar"]
