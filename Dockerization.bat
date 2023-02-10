@echo off

docker build -t=selenium-docker/selenium-docker .

docker-compose up -d