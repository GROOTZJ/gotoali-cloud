package com.tzj.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class GotoaliControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GotoaliControllerApplication.class, args);
	}

}
