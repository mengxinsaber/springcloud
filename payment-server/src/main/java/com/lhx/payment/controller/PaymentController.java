package com.lhx.payment.controller;

import com.lhx.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author lhx
 * @description
 * @date 2020/4/26 14:04
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/paymentInfoOk/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoOk(id);
        log.info("*****result: " + result);
        return result;
    }

    @GetMapping("/lb/getPort")
    public String getPort1(HttpServletRequest request) {
        log.info("*****result: " + request.getServerPort());
        return String.valueOf(request.getServerPort());
    }
    @GetMapping("/payment/getPort")
    public String getPort2(HttpServletRequest request) {
        log.info("*****result: " + request.getServerPort());
        return String.valueOf(request.getServerPort());
    }

    @GetMapping("/paymentInfoTimeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoTimeout(id);
        log.info("*****result: " + result);
        return result;
    }

    @GetMapping("/paymentCircuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*****result: " + result);
        return result;
    }

}