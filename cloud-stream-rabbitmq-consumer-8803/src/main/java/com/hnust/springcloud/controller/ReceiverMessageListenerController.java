package com.hnust.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/26 12:36
 */
@RestController
@EnableBinding(Sink.class)  //指定为消费者
public class ReceiverMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT) //指定输入管道，读取消息
    public void input(Message<String> message){

        System.out.println("我是消费者 02 号，收到消息： " + message.getPayload() + "port: " + serverPort);

    }

}
