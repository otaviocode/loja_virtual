package backend.develoment; 
// Define o pacote ao qual esta classe pertence, chamado "backend.develoment". Pacotes organizam classes e facilitam o gerenciamento do projeto.

import org.springframework.boot.SpringApplication; 
// Importa a classe SpringApplication do Spring Boot, que é usada para rodar a aplicação.

import org.springframework.boot.autoconfigure.SpringBootApplication; 
// Importa a anotação @SpringBootApplication, que é uma combinação de várias anotações do Spring e simplifica a configuração da aplicação.

@SpringBootApplication 
// Marca a classe principal como uma aplicação Spring Boot. Inclui as anotações @Configuration, @EnableAutoConfiguration e @ComponentScan, o que configura e inicializa a aplicação.

public class LojaVirtualApplication { 
// Define a classe principal da aplicação chamada "LojaVirtualApplication". O nome da classe deve corresponder ao nome do arquivo Java.

    public static void main(String[] args) { 
    // O método main é o ponto de entrada da aplicação Java. É onde a execução do programa começa.

        SpringApplication.run(LojaVirtualApplication.class, args); 
        // Este comando inicializa a aplicação Spring Boot, chamando o método run() da classe SpringApplication, que arranca a aplicação com base nas configurações fornecidas.
    }

}
