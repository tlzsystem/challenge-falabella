FROM amazoncorretto:11-alpine-jdk
MAINTAINER samueltoloza.cl
COPY target/challenge-0.0.1-SNAPSHOT.jar challenge-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/challenge-0.0.1-SNAPSHOT.jar"]