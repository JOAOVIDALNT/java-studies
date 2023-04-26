package com.example.feignviacepconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignViaCepConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignViaCepConsumeApplication.class, args);
    }

}
