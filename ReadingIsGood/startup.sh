#!/bin/sh

mvn clean install

docker build --tag=readingisgood:latest .

docker-compose  -f ./src/main/resources/docker-compose.yml up -d