package com.example.spring_web_mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringWebMvcApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SpringWebMvcApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder
    configure(SpringApplicationBuilder application) {
        return application.sources(
                SpringWebMvcApplication.class);
    }
}
