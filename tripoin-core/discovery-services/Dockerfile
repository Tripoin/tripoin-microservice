FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/discovery-services-0.0.1-SNAPSHOT.jar discovery-services.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /discovery-services.jar