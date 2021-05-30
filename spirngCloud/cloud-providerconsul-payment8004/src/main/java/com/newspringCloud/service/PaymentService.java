package com.newspringCloud.service;

import com.newspringCloud.pojo.payment;

public interface PaymentService {

    public int create(payment payment);

    public payment getPaymentById(Long id);
}
