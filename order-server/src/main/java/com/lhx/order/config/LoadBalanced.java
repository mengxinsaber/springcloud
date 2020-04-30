package com.lhx.order.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lhx
 * @description
 * @date 2020/4/26 15:17
 */
@Configuration
public class LoadBalanced {
    @Bean
    public IRule iRule(){
        return new WeightedResponseTimeRule();
    }
}