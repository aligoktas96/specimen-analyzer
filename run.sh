#!/bin/bash

service_name="code-service"

# build jar file
mvn clean install

# build docker image
docker build -t "${service_name}:latest" .

# start all instances
docker-compose up
