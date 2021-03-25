package com.hnust.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.hnust.springcloud.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/26 14:49
 */
@RestController
public class PaymentController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PaymentController.class);
    private static final org.slf4j.Logger loginLog = org.slf4j.LoggerFactory.getLogger("LoginLogger");
    private static final org.slf4j.Logger errorLog = org.slf4j.LoggerFactory.getLogger("ErrorLogger");
    private static final org.slf4j.Logger userActionLog = org.slf4j.LoggerFactory.getLogger("UserActionLogger");

    private int count = 0;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        log.error("error error error" +count);
        log.warn("warn warn warn"+count);
        log.info("info info info"+count);
        log.debug("debug debug debug"+count);
        count++;
        return "Hello Nacos Discovery: " + serverPort + "\t id: " + id;
    }

    @RequestMapping("/login")
    public String login(){

//        uid|ip|eventType|timestamp
        StringBuffer msg = new StringBuffer();
        long time = System.currentTimeMillis();
        msg.append("165646|").append("192.168.177.1|").append("success|").append(time);
        loginLog.info("执行登录操作:{},{}",msg,count);
        count++;

        return "执行登录操作";
    }


    @RequestMapping("/error1")
    public String error(HttpServletRequest request){

        try {
            int i = 10/0;
            count++;
        } catch (Exception e) {
            Student student = new Student("zss", 122);
            String jsonStr = JSONObject.toJSONString(student);
            errorLog.error("Exception: {}",e);

            errorLog.error("url:{}, data:{}",request.getRequestURL(),jsonStr);
//            errorLog.error("出现异常：{},date:{}",e,jsonStr);
            e.printStackTrace();
        }

        return "出现异常";
    }

    @RequestMapping("/action")
    public String action(HttpServletRequest request, @RequestParam int i){
//动作日期|用户id|sessionId|页面id|查询词|点击类别id|收藏类别|评分类别|评论类别|观看类别|
// 点击电影id|收藏电影id|评分电影id|评论电影id|观看电影id|城市id

        long time = System.currentTimeMillis();
        StringBuffer msg = new StringBuffer();

        Long userId = 4655616L;
        String sessionId = request.getSession().getId();
        String pageId = request.getRequestURL().toString()+"?i="+i;
        String searchKeyWord = "火影忍者";
        String clickCategory = "";
        String collectCategory = "";
        String ratingCategory = "";
        String commentCategory = "";
        String playCategory = "";
        String cilckMovieId = "";
        String collectMovieId = "";
        String ratingMovieId = "";
        String commentMovieId = "";
        String playMovieId = "";
        int cityId = 9;

        msg.append(time).append("|")
                .append(userId).append("|")
                .append(sessionId).append("|")
                .append(pageId).append("|")
                .append(searchKeyWord).append("|")
                .append(clickCategory).append("|")
                .append(collectCategory).append("|")
                .append(ratingCategory).append("|")
                .append(commentCategory).append("|")
                .append(playCategory).append("|")
                .append(cilckMovieId).append("|")
                .append(collectMovieId).append("|")
                .append(ratingMovieId).append("|")
                .append(commentMovieId).append("|")
                .append(playMovieId).append("|")
                .append(cityId);

        userActionLog.error("用户行为:{},{}",msg,count);
        count++;

        return "用户行为";
    }

}
