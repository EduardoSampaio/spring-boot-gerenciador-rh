FROM openjdk:8
ADD target/spring-boot-gerenciador-rh.jar spring-boot-gerenciador-rh.jar
EXPOSE 8080
ENTRYPOINT [ "java" ,"-jar","spring-boot-gerenciador-rh.jar","-Dspring.profiles.active=dev"]