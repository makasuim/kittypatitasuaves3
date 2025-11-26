package com.mazanex.pago.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Pago Service API",
                version = "1.0",
                description = "Documentación del microservicio de pagos"
        )
)
public class swagger {

}
