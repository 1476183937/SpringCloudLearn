package com.hnust.springcloud.controller;

import com.hnust.springcloud.domain.Order;
import com.hnust.springcloud.entities.CommonResult;
import com.hnust.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/28 20:39
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;


    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }


}


