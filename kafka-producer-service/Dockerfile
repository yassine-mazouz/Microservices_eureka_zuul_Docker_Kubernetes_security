FROM openjdk:8-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} kafka-producer-service-1.0.0-RELEASE.jar
ENTRYPOINT ["java","-jar","/kafka-producer-service-1.0.0-RELEASE.jar"]
