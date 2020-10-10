FROM openjdk:11-jdk-slim
COPY "./target/Back-End_Cambio-0.0.1-SNAPSHOT.jar" "reto.jar"
EXPOSE 8081
ENTRYPOINT ["java","-jar","reto.jar"]