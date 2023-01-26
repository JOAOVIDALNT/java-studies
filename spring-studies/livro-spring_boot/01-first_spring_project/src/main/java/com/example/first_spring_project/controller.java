package com.example.first_spring_project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {


    @RequestMapping("/")
    String home() {
        return "Nesse primeiro exemplo, usamos o spring boot com a dependencia spring web, que facilita todo o processo de configuração para a web, ainda assim é possivel setar configurações adicionais em resources/application.properties :) neste exemplo setamos a porta do servidor que geralmente é padrao localhost:8080 para a porta 9000 -> localhost:9000";
    }
}
