FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/config-service-0.0.1-SNAPSHOT.jar config-service.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /config-service.jar