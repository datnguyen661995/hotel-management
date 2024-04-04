FROM maven:3.8.1-openjdk-17-slim AS builder

WORKDIR /app

COPY ./pom.xml .
RUN mvn verify --fail-never

COPY . .
RUN mvn package

FROM openjdk:17.0.2-jdk

COPY --from=builder /app/target/hm-service.jar /opt/app.jar

ENTRYPOINT ["java","-jar","opt/app.jar"]
