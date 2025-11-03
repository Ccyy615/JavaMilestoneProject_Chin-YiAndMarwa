# ---- Build stage ----
FROM gradle:8.5-jdk17 AS build
WORKDIR /home/gradle/project
COPY . .
RUN gradle bootJar --no-daemon

# ---- Package stage ----
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
