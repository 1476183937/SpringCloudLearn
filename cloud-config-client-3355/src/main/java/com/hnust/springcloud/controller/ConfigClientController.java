package com.hnust.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/25 20:05
 */
@RestController
@Slf4j
@RefreshScope  //实现动态刷新配置需要
public class ConfigClientController {

    // 因为config仓库以rest形式暴露，所以所有客户端都可以通过config服务端访问到github上对应的文件信息
    //github上config-dev.yml中的内容：
    // config:
    //    info: "dev config-dev.yml dev"
    //会自动找到info标签的内容
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return  configInfo;
    }

}
