package com.graalvm.compilationtest.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import java.util.Map;

@Configuration
public class ExampleRouter { // usualmente en rest sincrono se usan @restcontroller pero estos usan reflection y son incompatibles con graalvm
// ahora se llame ExampleRouter porque el nombre iniciando con Test causa problemas con las pruebas unitarias
    @Bean
    public RouterFunction<ServerResponse> routes() {
        return RouterFunctions.route()
            .GET("/api/hello", req -> 
                ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(Map.of("message", "hello world")))
            .build();
    }
}