package com.spirngnewCloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    private static final String URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @GetMapping("/payment/consul")
    public String paymentInfo(){
        String result = restTemplate.getForObject(URL+"/payment/payment/consul",String.class);
        return result;
    }
}
