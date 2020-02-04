FROM openjdk:8
ADD target/controle-cpf.jar controle-cpf.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "controle-cpf.jar"]