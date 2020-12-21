#!/bin/bash -x

mvn package -DskipTests
docker build --tag rpc-client:latest .