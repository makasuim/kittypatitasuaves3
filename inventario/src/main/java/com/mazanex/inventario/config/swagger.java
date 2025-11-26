package com.mazanex.inventario.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Inventario Service API",
                version = "1.0",
                description = "Documentación del microservicio de inventario"
        )
)
public class swagger{

}
