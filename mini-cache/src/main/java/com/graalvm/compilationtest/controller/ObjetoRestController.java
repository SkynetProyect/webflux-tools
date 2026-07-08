package com.graalvm.compilationtest.controller;

import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.graalvm.compilationtest.service.objeto.ObjetoServiceInterface;
//import com.graalvm.compilationtest.dto.ObjetoDto;
import com.graalvm.compilationtest.model.objeto.Objeto;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/objeto")
public class ObjetoRestController {

    private final ObjetoServiceInterface objetoService;

    public ObjetoRestController(ObjetoServiceInterface objetoService) {
        this.objetoService = objetoService;
    }
    
    @GetMapping("/all")
    public Flux<Objeto> readAll() {
        return objetoService.readAll();
    }

    @GetMapping("/byId/{id}")
    public Mono<Objeto> readById(@PathVariable Long id) {
        return objetoService.readById(id);
    }

    @PostMapping
    public Mono<Objeto> create(@RequestBody Objeto objeto) {
        return objetoService.create(objeto);
    }

    @PutMapping
    public Mono<Objeto> update(@RequestBody Objeto objeto) {
        return objetoService.update(objeto);
    }

    @DeleteMapping("/byId/{id}")
    public Mono<Boolean> delete(@PathVariable Long id) {
        return objetoService.delete(id);
    }
}