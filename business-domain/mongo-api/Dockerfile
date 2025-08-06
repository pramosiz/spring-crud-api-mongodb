FROM eclipse-temurin:17-jdk-noble

RUN mkdir /jars /logs /logs/user-service

COPY target/crud-api-*.jar /jars/crud-api.jar
COPY src/main/resources/logback-spring.xml /logs/logback-spring.xml

RUN chmod -R 777 /logs

#Images label
LABEL vendor1="Pablo Rizqu"

ENTRYPOINT ["java","-jar","/jars/crud-api.jar"]