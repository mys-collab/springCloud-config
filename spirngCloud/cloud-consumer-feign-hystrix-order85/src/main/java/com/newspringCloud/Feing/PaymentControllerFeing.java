package com.newspringCloud.Feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * feing调用降级+feing调用
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentControllerFeingImpl.class)
public interface PaymentControllerFeing {
    @GetMapping("/payment/hystrixok/{id}")
    public String paymentInfo_Ok(@PathVariable("id")Integer id);
    @GetMapping("/payment/hystrixout/{id}")
    public String paymentInfo_out(@PathVariable("id")Integer id);
}
