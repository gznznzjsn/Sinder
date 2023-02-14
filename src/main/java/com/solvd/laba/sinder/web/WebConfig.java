package com.solvd.laba.sinder.web;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        servers = {
                @Server(url = "http://localhost:8080", description = "default server"),
                @Server(url = "http://localhost", description = "nginx server")
        }
)
public class WebConfig {
}
