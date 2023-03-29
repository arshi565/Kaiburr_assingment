FROM openjdk:11-jre-slim
COPY target/my-app.jar /usr/src/my-app/
WORKDIR /usr/src/my-app
CMD ["java", "-jar", "my-app.jar"]
