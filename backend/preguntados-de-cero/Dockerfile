FROM sapmachine:21.0.10.0.1-jre-alpine-3.22

WORKDIR /preguntados-de-cero

COPY build/libs/*.jar /preguntados-de-cero/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]