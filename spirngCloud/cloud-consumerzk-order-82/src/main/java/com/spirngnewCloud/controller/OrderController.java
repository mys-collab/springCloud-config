package com.spirngnewCloud.controller;

import com.newspringCloud.pojo.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

   // private static final String URL = "http://localhost:8001";
    private static final String URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @GetMapping(value = "/consumer/get/{id}")
    public CommonResult getById(@PathVariable("id")Long id){

        return restTemplate.getForObject(URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/payment/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(URL+"/payment/payment/zk",String.class);
        return result;
    }


}
