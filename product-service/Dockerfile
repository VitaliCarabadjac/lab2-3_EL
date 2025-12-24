# ===============================
# Build stage (Gradle)
# ===============================
FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /workspace/app

# Копируем всё
COPY . .

# Даем права gradlew
RUN chmod +x gradlew

# Собираем jar
RUN ./gradlew clean build -x test

# ===============================
# Runtime stage
# ===============================
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Копируем jar
COPY --from=build /workspace/app/build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
