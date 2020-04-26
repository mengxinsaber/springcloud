package com.lhx.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lhx
 * @description
 * @date 2020/4/26 14:04
 */
@RestController
@Slf4j
public class PaymentController {


    @PostMapping("/getPaymentResult")
    public String getPaymentResult(HttpServletRequest request){
        log.info(String.valueOf(request.getServerPort()));
        return "success";
    }



    @PostMapping("/getPayment")
    public String getPayment(){
        return "success_feign";
    }
}