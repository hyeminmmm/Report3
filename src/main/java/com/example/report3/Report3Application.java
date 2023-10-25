package com.example.report3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Report3Application {

    public static void main(String[] args) {
        SpringApplication.run(Report3Application.class, args);
    }

}
