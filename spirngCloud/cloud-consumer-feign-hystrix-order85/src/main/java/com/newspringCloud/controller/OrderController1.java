package com.newspringCloud.controller;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.newspringCloud.Feing.PaymentControllerFeing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局配置降级
 */
@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderController1 {



    @Autowired
    private PaymentControllerFeing feing;

    private static final Logger logger = LoggerFactory.getLogger(OrderController1.class);


    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/order85/hystrixok1/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        String s = feing.paymentInfo_Ok(id);
        logger.info("paymentInfo_ok=======" + s);
        return s;
    }


    @HystrixCommand
    @GetMapping("/order85/hystrixout1/{id}")
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

    //全局配置fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后在式";
    }


}
