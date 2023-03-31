package com.example.chatapp;

import com.jjeanjacques.chatgpt.ChatGpt;
import com.jjeanjacques.chatgpt.EnableGpt;
import com.jjeanjacques.chatgpt.gateway.rest.ChatClient;
import com.jjeanjacques.chatgpt.gateway.rest.ImageClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableGpt
public class ChatappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatappApplication.class, args);

		ChatGpt chatGpt = new ChatGpt();
	}

}
