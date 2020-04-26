package com.lhx.payment.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lhx
 * @description
 * @date 2020/4/26 19:48
 */
@Service
public class PaymentService {

    public String paymentInfoOk(Integer id) {
        return "线程池： " + Thread.currentThread().getName()
                + "   paymentInfo_OK,id:" + id + " 正常访问！";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "", value = "")
    })
    public String paymentInfoTimeout(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e){
            e.printStackTrace();
        }
        return paymentInfoOk(id);
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e){
            e.printStackTrace();
        }
        return paymentInfoOk(id);
    }
}