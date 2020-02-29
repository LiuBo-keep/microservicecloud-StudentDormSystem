package com.hp.bishe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.hp.bishe"})
@ComponentScan("com.hp.bishe")
@EnableScheduling
public class BiSheConsumer80_APP {

    public static void main(String[] args) {
        SpringApplication.run(BiSheConsumer80_APP.class,args);
    }
}
