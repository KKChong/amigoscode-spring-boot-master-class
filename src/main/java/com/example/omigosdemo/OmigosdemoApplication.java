package com.example.omigosdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OmigosdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OmigosdemoApplication.class, args);
    }

}
