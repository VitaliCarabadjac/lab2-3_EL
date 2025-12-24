# ===============================
# Build stage
# ===============================
FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /workspace/app

# Копируем проект
COPY . .

# Собираем jar (БЕЗ mvnw)
RUN mvn clean package -DskipTests

# ===============================
# Runtime stage
# ===============================
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY --from=build /workspace/app/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
