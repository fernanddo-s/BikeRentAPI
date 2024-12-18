package com.aluguelbicicleta.aluguelbicicleta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Desabilitando spring security com (exclude = {ReactiveSecurityAutoConfiguration.class})
//Retirar quando for usar autenticação
@SpringBootApplication(exclude = {ReactiveSecurityAutoConfiguration.class})
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
