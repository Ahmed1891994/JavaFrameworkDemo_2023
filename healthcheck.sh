#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# MODULE

echo "Checking if hub is ready - 192.168.1.4"
echo "$localhost"

while [ "$( curl -s http://192.168.1.4:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

# start the java command
java -cp JavaFrameworkDemo-0.0.1-SNAPSHOT.jar:JavaFrameworkDemo-0.0.1-SNAPSHOT-tests.jar:libs/* \
    -DHUBHOST=192.168.1.4 -Denv=prod org.testng.TestNG $MODULE
    