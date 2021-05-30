package com.newspringCloud.controller;

import cn.hutool.core.util.IdUtil;
import com.newspringCloud.Feing.PaymentControllerFeing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * feing调用降级
 */
@RestController
public class OrderController2 {



    @Autowired
    private PaymentControllerFeing feing;

    private static final Logger logger = LoggerFactory.getLogger(OrderController2.class);


    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/order85/hystrixok2/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        String s = feing.paymentInfo_Ok(id);
        logger.info("paymentInfo_ok=======" + s);
        return s;
    }

    @GetMapping("/order85/hystrixout2/{id}")
    public String paymentInfo_out(@PathVariable("id") Integer id) {
        try {
            Thread.sleep(5000);
            String s = IdUtil.randomUUID();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s = feing.paymentInfo_out(id);
        logger.info("paymentInfo_out=======" + s);
        return s + "===" + serverPort;
    }

}
