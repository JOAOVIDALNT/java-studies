package br.dev.joaovidal.table;

import br.dev.joaovidal.table.enums.Status;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "Table API para gerenciamento de leituras",
				version = "1.0.0",
				description = "Desenvolvido por João Vidal"),
		servers = {
				@Server(url = "http://localhost:8080"), // já é estabelecido por padrão mas é possível adicionar outros servidores da api
				// @Server(url= "http://seusite.com/table)
		}
)
public class TableApplication {

	public static void main(String[] args) {
		SpringApplication.run(TableApplication.class, args);
	}


}
