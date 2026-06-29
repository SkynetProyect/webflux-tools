package com.graalvm.compilationtest.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.graalvm.HelloResponse;
import java.util.Map;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

@Configuration
public class TestRouter { // usualmente en rest sincrono se usan @restcontroller pero estos usan reflection y son incompatibles con graalvm

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return RouterFunctions.route()
            .GET("/proto/hello", req -> {
                HelloResponse response = HelloResponse.newBuilder()
                    .setMessage("hello protobuf world")
                    .setCode(200)
                    .build();
                byte[] bytes = response.toByteArray();

                return ServerResponse.ok()
                    .contentType(MediaType.parseMediaType("application/x-protobuf"))
                    .contentLength(bytes.length)
                    .bodyValue(bytes);
            })
            .build();
    }
}