FROM openjdk:17-jdk-alpine
EXPOSE 8080
COPY target/ecommerce-task.jar ecommerce-task.jar
ENTRYPOINT ["java", "-jar", "/ecommerce-task.jar"]