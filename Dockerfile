FROM openjdk:23
EXPOSE 8083
ADD target/springboot-devops-integration.jar springboot-devops-integration.jar
ENTRYPOINT ["java", "-jar", "/springboot-devops-integration.jar"]