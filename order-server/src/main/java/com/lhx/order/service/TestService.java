package com.lhx.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lhx
 * @description
 * @date 2020/4/26 19:14
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE"
/**, fallback = PaymentFallbackService.class*/
)
public interface TestService {

    @GetMapping("/paymentInfoOk/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id);

    @GetMapping("/paymentInfoTimeout/{id}")
    String paymentInfoTimeout(@PathVariable("id") Integer id);

    @GetMapping("/lb/getPort")
    String getPortByLb();

    @GetMapping("/payment/getPort")
    String getPort();

}