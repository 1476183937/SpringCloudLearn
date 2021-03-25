package com.hnust.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/23 22:34
 */
@Configuration
public class MySelfRule {

    /**
    *@title: 
    *@description: 使用ribbon的随机负载均衡
    *@author:ggh
    *@updateTime: 2020/4/23 22:36
    **/
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
