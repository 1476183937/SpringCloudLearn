package com.hnust.springcloud.service;

import java.math.BigDecimal;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/28 20:53
 */
public interface AccountService {

    void decrease(Long userId, BigDecimal money);
}


