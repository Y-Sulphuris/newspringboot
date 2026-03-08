package com.ydo4ki.newspringboot;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("User API")
                        .version("1.0")
                        .description("API for managing users")
                        .description("Ok I actually didn't expect it to be that easy")
                        .contact(new Contact()
                                .name("Student Support")
                                .email("support@example.com")));
    }
}