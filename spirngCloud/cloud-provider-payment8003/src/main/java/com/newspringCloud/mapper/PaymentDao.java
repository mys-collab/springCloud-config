package com.newspringCloud.mapper;

import com.newspringCloud.pojo.payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public int create(payment payment);

    public payment getPaymentById(@Param("id") Long id);
}
