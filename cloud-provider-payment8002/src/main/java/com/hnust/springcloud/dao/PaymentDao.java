package com.hnust.springcloud.dao;

import com.hnust.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/21 12:10
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
