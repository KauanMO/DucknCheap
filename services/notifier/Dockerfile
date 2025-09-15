FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/*.jar notifier.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "notifier.jar"]
