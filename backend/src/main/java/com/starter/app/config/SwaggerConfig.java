package com.starter.app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Development Starter Kit API")
            .description("Spring Boot 3.x + Java 21 Development Starter Kit API Documentation")
            .version("v1.0.0")
            .contact(new Contact()
                .name("Development Team")
                .email("dev@example.com")))
        .servers(List.of(
            new Server().url("http://localhost:8080").description("Local Server (Direct)"),
            new Server().url("http://localhost").description("Local Server (Nginx Proxy)")
        ));
  }
}
