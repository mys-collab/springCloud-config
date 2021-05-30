package com.springCloud.controller;

import com.springCloud.service.PaymentService;
import com.springCloud.service.PaymentService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaymentController1 {

    @Autowired
    private PaymentService1 paymentService1;

    @Value("${server.port}")
    private String serverPort;


    private static final Logger logger = LoggerFactory.getLogger(PaymentController1.class);


    @GetMapping("/payment/hystrixok1/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        String s = paymentService1.paymentInfo_ok(id);
        logger.info("paymentInfo_ok=======" + s);
        return s;
    }

    @GetMapping("/payment/hystrixout1/{id}")
    public String paymentInfo_out(@PathVariable("id") Integer id) {
        String s = paymentService1.paymentInfoTimeOut(id);
        logger.info("paymentInfo_out=======" + s);
        return s + "===端口：" + serverPort;
    }

}
