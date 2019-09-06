package com.tzj.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GotaliGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GotaliGatewayApplication.class, args);
    }

}
