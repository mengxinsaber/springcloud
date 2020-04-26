package com.lhx.order.controller;

import com.lhx.order.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lhx
 * @description
 * @date 2020/4/26 10:48
 */
@RestController
public class OrderManageController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private TestService testService;

    @GetMapping("/getOrder")
    public String getOrder() {
        return restTemplate.postForObject("http://CLOUD-PAYMENT-SERVICE/getPaymentResult", null, String.class);
    }

    @GetMapping("/getOrderByFeign")
    public String getOrderByFeign() {
        return testService.getPayment();
    }

}