FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/*.jar users.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "users.jar"]
