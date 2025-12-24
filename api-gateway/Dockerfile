# ===============================
# Build stage
# ===============================
FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /workspace/app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# ===============================
# Runtime stage
# ===============================
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /workspace/app/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
