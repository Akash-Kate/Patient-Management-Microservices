#FROM maven:3.9.9-eclipse-temurin-17 AS builder
#
#WORKDIR /app
#
#COPY pom.xml .
#RUN mvn dependency:go-offline -B
#
#COPY src ./src
#RUN mvn clean package
#
#FROM eclipse-temurin:17-jdk AS runner
#
#WORKDIR /app
#
#COPY --from=builder /app/target/patient-service-0.0.1-SNAPSHOT.jar app.jar
#
#EXPOSE 4000
#RUN ls -l /app/target
#ENTRYPOINT ["java", "-jar", "app.jar"]



FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline
EXPOSE 4005
CMD ["mvn", "spring-boot:run"]


#FROM eclipse-temurin:17-jdk
#
#WORKDIR /app
#
#COPY target/*.jar app.jar
#
#ENTRYPOINT ["java", "-jar", "app.jar"]










