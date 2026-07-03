package com.graalvm.compilationtest.controller;

import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.graalvm.compilationtest.service.objeto.ObjetoService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/objeto")
public class ObjetoRestController {

    private final ObjetoService objetoService;

    public ObjetoRestController(ObjetoService objetoService) {
        this.objetoService = objetoService;
    }

    @GetMapping("/all")
    public Mono<String> getAll() {
        return Mono.just("GET ALL CALLED");
    }

    @GetMapping("/byId/{id}")
    public Mono<String> getById(@PathVariable Long id) {
        return Mono.just("GET BY ID CALLED: " + id);
    }

    @PostMapping
    public Mono<String> create() {
        return Mono.just("CREATE CALLED");
    }

    @PutMapping
    public Mono<String> update() {
        return Mono.just("MODIFY CALLED");
    }

    @DeleteMapping("/byId/{id}")
    public Mono<String> delete(@PathVariable Long id) {
        return Mono.just("DELETE CALLED: " + id);
    }
}