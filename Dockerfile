FROM amazoncorretto:23-jdk
EXPOSE 8083
ADD target/springboot-devops-integration.jar springboot-devops-integration.jar
ENTRYPOINT ["java", "-jar", "/springboot-devops-integration.jar"]