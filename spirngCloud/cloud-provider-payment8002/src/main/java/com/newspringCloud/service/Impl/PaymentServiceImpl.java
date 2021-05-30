package com.newspringCloud.service.Impl;

import com.newspringCloud.mapper.PaymentDao;
import com.newspringCloud.pojo.payment;
import com.newspringCloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
