package com.newspringCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //启动发现客户端
public class ConfigApplication3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication3344.class, args);
    }
}