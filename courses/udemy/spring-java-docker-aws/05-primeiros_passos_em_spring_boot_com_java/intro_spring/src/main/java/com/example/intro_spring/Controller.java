package com.example.intro_spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    // Espera o parâmetro na url e caso não obtenha retorna o valor padrão "World"
    // exemplo de parâmetro na url: http://localhost:8080/greeting?name=João
    // retorno com parâmetro: {"id":2,"content":"Hello, João!"}
    // url sem parâmetro: http://localhost:8080/greeting
    // returno sem parâmetro: {"id":3,"content":"Hello, World!"}
    

}
