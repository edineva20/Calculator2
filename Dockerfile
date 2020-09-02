FROM openjdk:8-jre
COPY build/libs/calculator2-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
