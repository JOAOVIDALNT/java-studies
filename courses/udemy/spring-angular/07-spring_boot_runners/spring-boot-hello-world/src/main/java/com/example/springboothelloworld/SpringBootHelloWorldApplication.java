package com.example.springboothelloworld;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootHelloWorldApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("*** Show Arguments ***");;
		Arrays.stream(args).forEach(System.out::println);
	}
	// No input da aplicação fui em edit configs e adicionei 3 argumentos separados por espaço
	// quando o spring boot subir, vai printar cada um desses argumentos no terminal

	// também é possivel implementar a interface ApplicationRunner, mudaria apenas o argumento da função run de String... para ApplicationArguments e (args.getSourceArgs) na stream
}
