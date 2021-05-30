package com.newspringCloud.controller;

import com.newspringCloud.pojo.CommonResult;
import com.newspringCloud.pojo.payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {


   // private static final String URL = "http://localhost:8001";
    private static final String URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @PostMapping("/consumer")
    public CommonResult create(@RequestBody payment payment){
            return restTemplate.postForObject(URL+"/payment/create",payment,CommonResult.class);

    }

    @GetMapping(value = "/consumer/get/{id}")
    public CommonResult getById(@PathVariable("id")Long id){

        return restTemplate.getForObject(URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping(value = "/newconsumer/get/{id}")
    public CommonResult getByIdnew(@PathVariable("id")Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            logger.info("状态+=="+forEntity.getStatusCode());
            return forEntity.getBody();
        }
        return new CommonResult(9999,"失败");
    }

}
