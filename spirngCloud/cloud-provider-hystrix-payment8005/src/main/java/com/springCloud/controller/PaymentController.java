package com.springCloud.controller;

import com.springCloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);


    @GetMapping("/payment/hystrixok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        String s = paymentService.paymentInfo_ok(id);
        logger.info("paymentInfo_ok=======" + s);
        return s;
    }

    @GetMapping("/payment/hystrixout/{id}")
    public String paymentInfo_out(@PathVariable("id") Integer id) {
        String s = paymentService.paymentInfoTimeOut(id);
        logger.info("paymentInfo_out=======" + s);
        return s + "===" + serverPort;
    }

}
