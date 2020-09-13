FROM openjdk:11.0.8-jre-slim

ADD target/serviceA-*.jar app.jar
ADD agent agent

ENTRYPOINT [ "java","-javaagent:agent/skywalking-agent.jar", "-jar" ,"app.jar"]