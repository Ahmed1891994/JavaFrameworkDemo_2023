FROM openjdk:8u212-jdk-alpine3.9

RUN apk add curl jq

# WorkSpace
WORKDIR /usr/shared

#Add .jar files to the workspace
ADD target/JavaFrameworkDemo-0.0.1-SNAPSHOT.jar			.
ADD target/JavaFrameworkDemo-0.0.1-SNAPSHOT-tests.jar	.
ADD target/libs											.

# Add suitefiles
ADD testng.xml											testng.xml

# ADD health check script
ADD healthcheck.sh healthcheck.sh
RUN dos2unix healthcheck.sh

# HUB_HOST
# MODULE
ENTRYPOINT sh healthcheck.sh