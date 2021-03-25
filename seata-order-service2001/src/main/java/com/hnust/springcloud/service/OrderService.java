package com.hnust.springcloud.service;

import com.hnust.springcloud.domain.Order;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/28 20:35
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}


