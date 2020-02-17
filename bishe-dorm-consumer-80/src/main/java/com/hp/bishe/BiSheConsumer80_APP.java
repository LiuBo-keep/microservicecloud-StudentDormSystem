package com.hp.bishe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.hp.bishe"})
@ComponentScan("com.hp.bishe")
public class BiSheConsumer80_APP {

    public static void main(String[] args) {
        SpringApplication.run(BiSheConsumer80_APP.class,args);
    }
}
