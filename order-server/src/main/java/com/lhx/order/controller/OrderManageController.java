package com.lhx.order.controller;

import com.lhx.order.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS;

/**
 * @author lhx
 * @description
 * @date 2020/4/26 10:48
 */
@RestController
@DefaultProperties(defaultFallback = "paymentInfoGlobalFallbackMethod")
public class OrderManageController {

//    @Resource
//    private RestTemplate restTemplate;

    @Resource
    private TestService testService;

    @HystrixCommand
    @GetMapping("/getPortByLb")
    public String getPortByLb() {
        return testService.getPortByLb();
    }
    @HystrixCommand
    @GetMapping("/getOrder")
    public String getOrder() {
        return testService.getPort();
    }

    @GetMapping("/paymentInfoTimeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutFallbackMethod",commandProperties = {
            @HystrixProperty(name = EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS,value = "2000")
    })
    public String paymentInfoTimeout(@PathVariable("id") Integer id){
        return testService.paymentInfoTimeout(id);
    }

    @HystrixCommand
    @GetMapping("/paymentInfoOk/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        return testService.paymentInfoOk(id);
    }

    public String paymentInfoTimeoutFallbackMethod(Integer id) {
        return "/(ToT)/我是消费者80，调用8001支付系统繁忙，请10秒钟后重新尝试、\t";
    }

    // 下面是全局fallback方法
    public String paymentInfoGlobalFallbackMethod() {
        return "Global异常处理信息，请稍后再试， /(ToT)/";
    }
}