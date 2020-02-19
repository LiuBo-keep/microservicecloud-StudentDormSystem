package com.hp.bishe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient   //本服启动后会自动注册进eureka服务中
//@EnableDiscoveryClient //服务发现
public class TeacherProvider8082_App {

    public static void main(String[] args) {
        SpringApplication.run(TeacherProvider8082_App.class,args);
    }
}
