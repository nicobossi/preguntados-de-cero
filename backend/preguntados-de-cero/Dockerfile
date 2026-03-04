FROM eclipse-temurin:21-jre-alpine

WORKDIR /preguntados-de-cero

COPY build/libs/*.jar /preguntados-de-cero/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]