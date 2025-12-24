# ===============================
# Build stage
# ===============================
FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /workspace/app

# Копируем ВСЁ (включая gradlew)
COPY . .

# Даем права на gradlew
RUN chmod +x gradlew

# Собираем jar
RUN ./gradlew build -x test

# ===============================
# Runtime stage
# ===============================
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Копируем jar (Spring Boot)
COPY --from=build /workspace/app/build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
