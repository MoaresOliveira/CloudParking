package io.github.moaresoliveira.cloudparking.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("CloudParking API")
                        .description("Parking application")
                        .version("v0.0.1")
                        .contact(new Contact().name("Moares Oliveira")
                                .url("https://github.com/MoaresOliveira")));
    }



}
