# Usa imagem do Maven para build
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

# Usa imagem do JDK para rodar a aplicação
FROM eclipse-temurin:17
WORKDIR /app
COPY --from=build /app/target/financeApp-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
