package desafio.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * @author acacio.leal
 * Classe main para execução da aplicação
 */
@SpringBootApplication
@ComponentScan(basePackages = "desafio.spring")
public class DesafioSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(DesafioSpringApplication.class, args);
	}
}
