#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# MODULE

echo "Checking if hub is ready - $HUB_HOST"

while [ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

# start the java command
java -cp JavaFrameworkDemo-0.0.1-SNAPSHOT.jar:JavaFrameworkDemo-0.0.1-SNAPSHOT-tests.jar:libs/* \
    -DHUB_HOST=$HUB_HOST \
    -Denv=prod \
    org.testng.TestNG $MODULE