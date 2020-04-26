package com.lhx.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author lhx
 * @description
 * @date 2020/4/26 19:14
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface TestService {

    @PostMapping("/getPayment")
    public String getPayment();
}