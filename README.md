# Spring Boot with Grpc
    This is dummy project which contains implementation of grpc server and grpc client with Error handling.

## Spring-boot-grpc-starter
        <dependency>
            <groupId>net.devh</groupId>
            <artifactId>grpc-spring-boot-starter</artifactId>
            <version>2.14.0.RELEASE</version>
        </dependency>
 - GitUrl : https://github.com/yidongnan/grpc-spring-boot-starter

## Build protos module
- mvn clean install

## Datadog APM Agent JVM arguments 
- -javaagent:{directory}/dd-java-agent.jar -Ddd.logs.injection=true -Ddd.profiling.enabled=true -Ddd.service={service_name} -Ddd.env=lab -XX:FlightRecorderOptions=stackdepth=256