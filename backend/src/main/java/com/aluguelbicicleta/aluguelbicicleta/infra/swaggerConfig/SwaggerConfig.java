package com.aluguelbicicleta.aluguelbicicleta.infra.swaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI configOpenApi(){
        return new OpenAPI().info(
            new Info().description("Descição da API")
            .version("1.0.0")
            .title("Documentação da API")
        );
    }
}
