FROM openjdk:8-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} organization-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/organization-service-0.0.1-SNAPSHOT.jar"]
