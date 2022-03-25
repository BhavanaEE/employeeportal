FROM openjdk:11
ADD target/demo-0.0.1-SNAPSHOT.jar /application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]