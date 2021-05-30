package com.newspringCloud.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.newspringCloud.Feing.PaymentControllerFeing;
import com.newspringCloud.pojo.CommonResult;
import com.newspringCloud.pojo.payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


/**
 * 方法降级
 */
@RestController
public class OrderController {



    @Autowired
    private PaymentControllerFeing feing;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/order85/hystrixok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        String s = feing.paymentInfo_Ok(id);
        logger.info("paymentInfo_ok=======" + s);
        return s;
    }

    //熔断超过三秒钟超时
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOut2",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @GetMapping("/order85/hystrixout/{id}")
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


    public String paymentInfoTimeOut2(Integer id){
        return "消费者系统繁忙----"+Thread.currentThread().getName()+"   paymentInfoTimeOut2"+id;
    }



}
