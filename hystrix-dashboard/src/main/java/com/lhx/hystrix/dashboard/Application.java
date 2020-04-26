package com.lhx.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author lhx
 * @description
 * @date 2020/4/26 19:35
 */
@SpringBootApplication
@EnableHystrixDashboard
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}