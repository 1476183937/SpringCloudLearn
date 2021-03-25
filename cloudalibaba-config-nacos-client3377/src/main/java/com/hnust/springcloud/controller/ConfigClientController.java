package com.hnust.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/26 20:40
 */
@RestController
@RefreshScope //要实现配置动态刷新必须要有这个注解
public class ConfigClientController {

    //获取nacos配置中心内的config下的info的值
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }

}
