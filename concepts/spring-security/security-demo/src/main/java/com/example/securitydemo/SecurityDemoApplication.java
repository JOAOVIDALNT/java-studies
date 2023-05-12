package com.example.securitydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }


    @RestController
    class HttpController {
        @GetMapping("/public")
        String publicRoute() {
            return "<h1> Public route, none authorization required </h1>";
        }

        @GetMapping("/private")
        String privateRoute() {
            return "<h1> Private route, authorization required </h1>";
        }

    }

}
