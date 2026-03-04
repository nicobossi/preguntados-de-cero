# STAGE 1


FROM gradle:jdk21-ubi AS builder

WORKDIR /preguntados-de-cero

COPY . /preguntados-de-cero

RUN ./gradlew clean build -x test


#STAGE 2

FROM sapmachine:21.0.10.0.1-jre-alpine-3.22

WORKDIR /preguntados-de-cero

COPY --from=builder /preguntados-de-cero/build/libs/*.jar /preguntados-de-cero/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]