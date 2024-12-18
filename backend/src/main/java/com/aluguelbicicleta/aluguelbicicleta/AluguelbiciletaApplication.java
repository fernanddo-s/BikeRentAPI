package com.aluguelbicicleta.aluguelbicicleta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// import io.swagger.v3.oas.annotations.OpenAPIDefinition;
// import io.swagger.v3.oas.annotations.info.Info;

//Desabilitando spring security com (exclude = {ReactiveSecurityAutoConfiguration.class})
//Retirar quando for usar autenticação
@SpringBootApplication(exclude = {ReactiveSecurityAutoConfiguration.class})
// @OpenAPIDefinition(info = @Info(title = "Controle e Aluguel de Bicicletas", version = "1.0", description = "API desenvolvida em Java para administrar entidades relacionadas ao controle e organização de alugueis de bicicletas em totens."))
public class AluguelbiciletaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AluguelbiciletaApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedHeaders("*")
				.allowedMethods("*");
			}
		};
	}

	
}
