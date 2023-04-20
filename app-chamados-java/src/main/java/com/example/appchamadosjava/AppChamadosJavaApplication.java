package com.example.appchamadosjava;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "API para criação e gerenciamento de chamados",
                version = "1.0.0",
                description = "Desenvolvido por João Vidal")
)
public class AppChamadosJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppChamadosJavaApplication.class, args);
    }

}
