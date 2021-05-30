package com.newspringCloud.Feing;

import org.springframework.stereotype.Component;

@Component
public class PaymentControllerFeingImpl implements PaymentControllerFeing{


    @Override
    public String paymentInfo_Ok(Integer id) {
        return "paymentInfo_Ok---fall back";
    }

    @Override
    public String paymentInfo_out(Integer id) {
        return "paymentInfo_out---fall back";
    }
}
