package com.extrawest.currencyExchangeMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableScheduling
public class CurrencyExchangeMicroserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeMicroserviceApplication.class, args);
    }
}
