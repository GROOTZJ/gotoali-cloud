package com.tzj.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GotoaliRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(GotoaliRedisApplication.class, args);
    }

//    @Value("${server.port}")
//    String port;
//    @RequestMapping("/")
//    public String home() {
//        return "hello world from port " + port;
//    }
}
