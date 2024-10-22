package backend.develoment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LojaVirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaVirtualApplication.class, args);
	}
}

/*
 * Resumo do Código:
 * 
 * Este código define a aplicação principal de uma loja virtual usando o
 * framework Spring Boot. A classe LojaVirtualApplication está marcada com a
 * anotação @SpringBootApplication, que é essencial para configurar
 * automaticamente o ambiente Spring e iniciar a aplicação.
 * 
 * O método main é o ponto de entrada do programa e usa SpringApplication.run
 * para iniciar a aplicação. O pacote definido como backend.development agrupa a
 * aplicação, ajudando na organização do código.
 * 
 * Em resumo, este código é a base para rodar uma aplicação Spring Boot,
 * inicializando automaticamente o servidor e as configurações necessárias para
 * o funcionamento da aplicação.
 */