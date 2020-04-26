package com.lhx.order.config.loadbalancer;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author lhx
 * @description
 * @date 2020/4/26 15:20
 */
public class GlobalRule implements IRule {

    private ILoadBalancer iLoadBalancer;

    @Override
    public Server choose(Object o) {
        List<Server> list = iLoadBalancer.getAllServers();
        return list.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.iLoadBalancer = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.iLoadBalancer;
    }
}