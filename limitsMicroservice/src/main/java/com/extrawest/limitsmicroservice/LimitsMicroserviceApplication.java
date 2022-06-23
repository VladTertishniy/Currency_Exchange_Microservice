package com.extrawest.limitsmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LimitsMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LimitsMicroserviceApplication.class, args);
    }

}
