package com.example.springboothelloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootHelloWorldApplication implements CommandLineRunner {
	@Autowired
	ConfigProperties configProperties;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("*** MAIL PROPERTIES ***");
		System.out.println("From: " +configProperties.getFrom());
		System.out.println("To: " +configProperties.getTo());
		System.out.println("Default Object: " +configProperties.getDefaultObject());
	}

}
