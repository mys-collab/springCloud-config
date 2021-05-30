package com.newspringCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.newspringCloud.Feing"})
//@EnableCircuitBreaker //启动熔断
public class OrderFeingHystrixApplication85 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeingHystrixApplication85.class, args);
    }

}
