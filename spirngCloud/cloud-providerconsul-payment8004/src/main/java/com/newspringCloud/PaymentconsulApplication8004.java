package com.newspringCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentconsulApplication8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentconsulApplication8004.class, args);
    }
}
