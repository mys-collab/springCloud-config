package com.newspringCloud.controller;

import com.newspringCloud.pojo.CommonResult;
import com.newspringCloud.pojo.payment;
import com.newspringCloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);


    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        payment payment = paymentService.getPaymentById(id);
        logger.info("查询结果..."+payment);

            return new CommonResult(200,"成功"+serverPort,payment);

    }

    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper: "+serverPort +"=="+ UUID.randomUUID().toString();
    }
}
