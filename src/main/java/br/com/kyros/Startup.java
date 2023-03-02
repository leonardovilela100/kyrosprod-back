package br.com.kyros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan(basePackages = { "br.com.kyros.model" })
@ComponentScan(basePackages = { "br.*" })
@EnableJpaRepositories(basePackages = "br.com.kyros.repositories")
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
public class Startup {

	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);

	}

}
