package com.hnust.springcloud.dao;

import com.hnust.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/28 20:30
 */
@Mapper
public interface OrderDao {

    /**
    *@title:
    *@description: 新建订单
    *@author:ggh
    *@updateTime: 2020/4/28 20:31
    **/
    int create(Order order);

    /**
    *@title:
    *@description: 更新订单状态
    *@author:ggh
    *@updateTime: 2020/4/28 20:32
    **/
    int update(@Param("userId") Long userId, @Param("status") Integer status);

}
