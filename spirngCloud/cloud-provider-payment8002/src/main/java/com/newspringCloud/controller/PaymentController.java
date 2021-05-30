package com.newspringCloud.controller;

import com.newspringCloud.pojo.CommonResult;
import com.newspringCloud.pojo.payment;
import com.newspringCloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @PostMapping("/create")
    public CommonResult create(@RequestBody payment payment){
        int i = paymentService.create(payment);
        logger.info("查询结果..."+i);
        if (i >0 ){
            return new CommonResult<>(200,"成功"+serverPort,i);
        }
        return  new CommonResult<>(9999,"失败");
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        payment payment = paymentService.getPaymentById(id);
        logger.info("查询结果..."+payment);

            return new CommonResult(200,"成功"+serverPort,payment);

    }
}
