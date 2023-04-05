package com.example.springboothelloworld;

import com.example.springboothelloworld.exception.UrlAccessException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class SpringBootHelloWorldApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}

	@EventListener(classes = ContextRefreshedEvent.class)
	public void listen() {
		throw new UrlAccessException("http://www.example.com");
	}

}
