package com.hp.bishe.cfgbeans;

import com.hp.bishe.utils.SessionUtil;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConBean {

    @Bean
    @LoadBalanced //SpringCloud Ribbon是基于Netflix Ribbon实现的一套客户端  负载均衡的工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public SessionUtil getSessionUtil(){
        return new SessionUtil();
    }
}
