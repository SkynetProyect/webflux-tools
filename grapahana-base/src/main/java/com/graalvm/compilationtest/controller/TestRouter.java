package com.graalvm.compilationtest.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.graalvm.compilationtest.service.OrderService;

@Configuration
public class TestRouter {

    private final OrderService orderService;

    public TestRouter(OrderService orderService) {
        this.orderService = orderService;
    }

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return RouterFunctions.route()
            .GET("/api/hello", req ->
                orderService.processOrder(2)
                    .flatMap(number ->
                        ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue("hello world")))
            .build();
    }
}