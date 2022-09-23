FROM openjdk:8-jdk-alpine
MAINTAINER michaelmld.com
COPY build/libs/idp-0.0.1-SNAPSHOT.jar idp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/idp-0.0.1-SNAPSHOT.jar"]



#https://medium.com/@chandupriya93/deploying-docker-containers-with-aws-ec2-instance-265038bba674
