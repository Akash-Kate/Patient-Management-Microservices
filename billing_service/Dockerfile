FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src


EXPOSE 4001
EXPOSE 9001

CMD ["mvn", "spring-boot:run"]