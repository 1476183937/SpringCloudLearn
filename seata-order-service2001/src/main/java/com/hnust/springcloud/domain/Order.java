package com.hnust.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/28 20:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    //订单状态：0 表示创建中 1表示已创建完成
    private Integer status;

}
