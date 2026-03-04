# STAGE 1


FROM gradle:jdk21-ubi AS builder

WORKDIR /preguntados-de-cero

COPY . /preguntados-de-cero

RUN ./gradlew clean build -x test


#STAGE 2

FROM eclipse-temurin:21-jre-alpine

WORKDIR /preguntados-de-cero

COPY --from=builder /preguntados-de-cero/build/libs/*.jar /preguntados-de-cero/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]