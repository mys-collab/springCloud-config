package com.springCloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentService1 {

    public String paymentInfo_ok(Integer id){
        return "线程池"+Thread.currentThread().getName()+"   paymentInfo-ok"+id;
    }

    //降级+熔断
    @HystrixCommand(fallbackMethod ="paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),//超过2秒超时 降级
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败多少百分率跳闸
    })
    public String paymentInfoTimeOut(Integer id){
        String s = IdUtil.randomUUID();
        try {
            if (id > 10 ){
                System.out.println("大于10==========");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "调用成功"+Thread.currentThread().getName()+"   流水号：=="+s;
    }


    public String paymentCircuitBreaker_fallback(Integer id){
        return "熔断系统--流程：服务的降级 -> 进入熔断 -> 恢复调用线路--"+Thread.currentThread().getName();
    }

}
