FROM openjdk:11-jre-slim
COPY target/myapp.jar /app.jar
CMD ["java", "-jar", "/app.jar"]
