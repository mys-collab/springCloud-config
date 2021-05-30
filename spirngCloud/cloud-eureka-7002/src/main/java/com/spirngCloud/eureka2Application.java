package com.spirngCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication()
@EnableEurekaServer
public class eureka2Application {
    public static void main(String[] args) {
        SpringApplication.run(eureka2Application.class, args);
    }
}
