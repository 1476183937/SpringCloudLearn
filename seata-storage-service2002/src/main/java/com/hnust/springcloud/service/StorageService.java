package com.hnust.springcloud.service;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/28 20:47
 */
public interface StorageService {

    void decrease(Long productId, Integer count);

}
