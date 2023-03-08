FROM openjdk:19-jdk-alpine3.16

RUN apk add curl jq

# WorkSpace
WORKDIR /usr/shared

#Add .jar files to the workspace
ADD target/framework_jar.jar .
ADD target/framework_jar-tests.jar .
ADD target/libs .

# Add suitefiles
ADD testng.xml .

# ADD health check script
ADD healthcheck.sh .
RUN dos2unix healthcheck.sh

# HUB_HOST
# MODULE
ENTRYPOINT sh healthcheck.sh