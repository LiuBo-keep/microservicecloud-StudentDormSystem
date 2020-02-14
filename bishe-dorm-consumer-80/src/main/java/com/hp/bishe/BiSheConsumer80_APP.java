package com.hp.bishe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BiSheConsumer80_APP {

    public static void main(String[] args) {
        SpringApplication.run(BiSheConsumer80_APP.class,args);
    }
}
