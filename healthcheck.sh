#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# MODULE

echo "Checking if hub is ready - $HUBHOST"

while [ "$( curl -s http://$HUBHOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

# start the java command
java -cp *-SNAPSHOT.jar:*-SNAPSHOT-tests.jar:libs/* -DHUBHOST=$HUBHOST -Denv=prod org.testng.TestNG $MODULE
    