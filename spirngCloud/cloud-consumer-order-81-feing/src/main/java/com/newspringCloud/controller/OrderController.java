package com.newspringCloud.controller;

import com.newspringCloud.Feing.PaymentControllerFeing;
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

    @Autowired
    private PaymentControllerFeing feing;


    @GetMapping(value = "/FeingId/get/{id}")
    public CommonResult getByFeingId(@PathVariable("id")Long id){
        CommonResult paymentById = feing.getPaymentById(id);
        return paymentById;
    }


}
