# Используем официальный образ Temurin 21.0.2 в качестве базового
FROM eclipse-temurin:21
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
