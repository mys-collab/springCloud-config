package com.newspringCloud.controller;

import com.newspringCloud.pojo.CommonResult;
import com.newspringCloud.pojo.payment;
import com.newspringCloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired//服务的启动发现
    private DiscoveryClient discoveryClient;

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

   // @GetMapping(value = "/get/{id}",produces={"application/json; charset=UTF-8"})
    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        payment payment = paymentService.getPaymentById(id);
        logger.info("查询结果..."+payment);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(200,"成功"+serverPort,payment);

    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        //所有
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            logger.info("*****"+service);
        }

        //所有
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
//*****instanceorg.springframework.cloud.netflix.eureka.EurekaDiscoveryClient$EurekaServiceInstance@51f552bc===192.168.43.171===8001==http://192.168.43.171:8001
            logger.info("*****instance"+instance+"==="+instance.getHost()+"==="+instance.getPort()+"=="+instance.getUri());
        }
        return this.discoveryClient;
    }


}
