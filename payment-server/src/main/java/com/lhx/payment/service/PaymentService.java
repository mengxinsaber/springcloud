package com.lhx.payment.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager.*;

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

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "2000")
    })
    public String paymentInfoTimeout(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentInfoOk(id);
    }

    public String paymentInfoTimeoutHandler(Integer id) {
        return "/(ToT)/调用支付接口超时或异常、\t" + "\t当前线程池名字" + Thread.currentThread().getName();
    }

    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = CIRCUIT_BREAKER_ENABLED, value = "true"),              //是否开启断路器
            @HystrixProperty(name = CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "10"),    //请求数达到后才计算
            @HystrixProperty(name = CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "10000"), //休眠时间窗
            @HystrixProperty(name = CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "60"),  //错误率达到多少跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("****id 不能为负数");
        }
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + System.currentTimeMillis();
    }

    public String paymentCircuitBreakerFallback(Integer id) {
        return "id 不能为负数,请稍后再试， o(╥﹏╥)o id: " + id;
    }
}