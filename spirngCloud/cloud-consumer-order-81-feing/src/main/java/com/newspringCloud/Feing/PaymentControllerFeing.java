package com.newspringCloud.Feing;

import com.newspringCloud.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Component
@RequestMapping("/payment")
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentControllerFeing {
    @GetMapping(value = "/payment/discovery")
    public Object discovery();

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);
}
