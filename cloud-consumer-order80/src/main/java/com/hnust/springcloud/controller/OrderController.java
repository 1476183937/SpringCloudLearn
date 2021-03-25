package com.hnust.springcloud.controller;

import com.hnust.springcloud.entities.CommonResult;
import com.hnust.springcloud.entities.Payment;
import com.hnust.springcloud.lb.LoadBalancer;
import com.hnust.springcloud.lb.MyLB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/22 21:10
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer myLB;

//    private static final String PAYMENT_URL="http://localhost:8001";
    private static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
//        restTemplate.getForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);

    }


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){

        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

    }

    /**
    *@title:
    *@description: 使用自定义的负载均衡器
    *@author:ggh
    *@updateTime: 2020/4/24 13:28
    **/
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {

        //使用自定义的负载均衡器，如果没有使用自定义的负载均衡器，就需要在ApplicationContextConfig类下使用@LoadBalanced 注解
        //二者不能同时使用
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = myLB.instance(serviceInstances);
        URI uri = instance.getUri();
        String result = restTemplate.getForObject(uri + "/payment/lb", String.class);
        return result;
    }

    //测试zipkin：链路监控
    @GetMapping(value="/consumer/payment/zipkin")
    public String paymentZipkin() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin/",String.class);
    }

}
