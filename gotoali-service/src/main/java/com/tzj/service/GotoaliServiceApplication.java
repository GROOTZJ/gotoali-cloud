package com.tzj.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class GotoaliServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GotoaliServiceApplication.class, args);
    }

}
