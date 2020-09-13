FROM openjdk:11.0.8-jre-slim

ADD target/serviceB-*.jar app.jar
ADD agent agent

ENTRYPOINT [ "java","-javaagent:agent/skywalking-agent.jar", "-jar" ,"app.jar"]