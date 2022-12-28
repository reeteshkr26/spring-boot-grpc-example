package com.jtech.sbg;

import com.jtech.sbg.trace.StatusInterceptor;
import datadog.trace.api.GlobalTracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcServerApplication {

    public static void main(String[] args){

        SpringApplication.run(GrpcServerApplication.class, args);
        GlobalTracer.get().addTraceInterceptor(new StatusInterceptor());
    }
}
