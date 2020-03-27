FROM openjdk:8
VOLUME /tmp
ADD target/spring-kafka-demo-0.0.1-SNAPSHOT.jar spring-kafka-demo-0.0.1-SNAPSHOT.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","spring-kafka-demo-0.0.1-SNAPSHOT.jar"]