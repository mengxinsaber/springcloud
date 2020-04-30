package com.lhx.order.service;

import org.springframework.stereotype.Component;

/**
 * @author lhx
 * @description
 * @date 2020/4/29 19:25
 */
@Component
public class PaymentFallbackService implements TestService{

    @Override
    public String paymentInfoOk(Integer id) {
        return null;
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return null;
    }

}