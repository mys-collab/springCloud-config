package com.springCloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    public String paymentInfo_ok(Integer id){
        return "线程池"+Thread.currentThread().getName()+"   paymentInfo-ok"+id;
    }

    //降级
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOut2",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfoTimeOut(Integer id){
        try {
            int a = 10/0;
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池"+Thread.currentThread().getName()+"   paymentInfo-InfoTimeOut"+id;
    }

    public String paymentInfoTimeOut2(Integer id){
        return "服务提供者系统繁忙----"+Thread.currentThread().getName()+"   paymentInfoTimeOut2"+id;
    }

}
