package com.hnust.springcloud.controller;

import com.hnust.springcloud.entities.CommonResult;
import com.hnust.springcloud.entities.Payment;
import com.hnust.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/21 12:25
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private EurekaDiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);

        if (result > 0){
            return new CommonResult(200, "插入数据成功, serverPort:" +serverPort, result);
        }else {
            return new CommonResult(444, "插入数据库失败",null);
        }

    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);

        if (payment != null){
            return new CommonResult(200, "获取数据成功, serverPort:" + serverPort, payment);
        }else {
            return new CommonResult(444, "获取数据失败", null);
        }

    }


    @RequestMapping("/payment/discovery")
    public Object discovery(){

        //获取服务注册中心有哪些服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.debug("=====serivce:" + service);
        }

        //获取指定服务名称的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance instance : instances) {
            //获取服务名称、主机号、url
            log.debug(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getUri());
        }

        return this.discoveryClient;

    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            return serverPort;
        }
    }

}
