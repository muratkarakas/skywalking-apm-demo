#!/bin/bash

cd ServiceA
./mvnw clean install
java  -javaagent:agent/skywalking-agent.jar -jar target/serviceA-0.0.1-SNAPSHOT.jar &

cd  ..
cd ServiceB
./mvnw clean install
java  -javaagent:agent/skywalking-agent.jar -jar target/serviceB-0.0.1-SNAPSHOT.jar &

cd ..
