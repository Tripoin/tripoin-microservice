FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/account-0.0.1-SNAPSHOT.jar account.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /account.jar