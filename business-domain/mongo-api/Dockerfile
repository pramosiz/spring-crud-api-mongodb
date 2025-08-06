FROM eclipse-temurin:17-jdk-noble

RUN mkdir /jars

COPY target/mongo-api-*.jar /jars/mongo-api.jar
COPY src/main/resources/log4j2.properties /jars/log4j2.properties

RUN chmod -R 777 /logs

#Images label
LABEL vendor1="Pablo Rizqu"

ENTRYPOINT ["java","-jar","/jars/mongo-api.jar"]