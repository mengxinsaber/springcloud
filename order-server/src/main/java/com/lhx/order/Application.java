package com.lhx.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lhx
 * @description
 * @date 2020/4/26 10:56
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
//@RibbonClient(name = "spring-boot-provider", configuration = LoadBalanced.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}