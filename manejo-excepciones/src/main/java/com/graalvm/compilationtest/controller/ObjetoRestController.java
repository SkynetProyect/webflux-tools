package com.graalvm.compilationtest.controller;

import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.graalvm.compilationtest.service.objeto.ObjetoServiceInterface;
import com.graalvm.compilationtest.dto.respuesta.Respuesta;
import com.graalvm.compilationtest.dto.entrada.objeto.ObjetoCreateDto;
import com.graalvm.compilationtest.dto.entrada.objeto.ObjetoUpdateDto;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import com.graalvm.compilationtest.model.objeto.Objeto;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Null;

@RestController
@RequestMapping("/api/objeto")
@Validated
public class ObjetoRestController {

    private final ObjetoServiceInterface objetoService;

    public ObjetoRestController(ObjetoServiceInterface objetoService) {
        this.objetoService = objetoService;
    }
    
    @GetMapping("/all")
    public Flux<ResponseEntity<Respuesta>> readAll() {
        return objetoService.readAll()
                .map( retorno -> ResponseEntity
                                .status(HttpStatus.OK)
                                .body(new Respuesta(
                                    "200",
                                    "Entidades listadas",
                                    retorno)
                                )
          );
    }

    @GetMapping("/byId/{id}")
    public Mono<ResponseEntity<Respuesta>> readById(@PathVariable
        @NotNull(message = "El id es obligatorio")
        @Positive(message = "El id debe ser mayor que cero")
        @Max(value = 9999999, message = "El id supera el máximo permitido")
        Long id) {
        return objetoService.readById(id)
                .map( retorno -> ResponseEntity
                                .status(HttpStatus.OK)
                                .body(new Respuesta(
                                    "200",
                                    "Entidad encontrada",
                                    retorno)
                                )
          );
    }

    @PostMapping
    public Mono<ResponseEntity<Respuesta>> create(@Valid @RequestBody ObjetoCreateDto objeto) {
        Objeto mapeo = new Objeto().setNombre(objeto.nombre());
        return objetoService.create(mapeo)
                .map( retorno -> ResponseEntity
                                .status(HttpStatus.OK)
                                .body(new Respuesta(
                                    "200",
                                    "Entidad Creada",
                                    retorno)
                                )
          );
    }

    @PutMapping
    public Mono<ResponseEntity<Respuesta>> update(@Valid @RequestBody ObjetoUpdateDto objeto) {
        Objeto mapeo = new Objeto().setId(objeto.id()).setNombre(objeto.nombre());
        return objetoService.update(mapeo)
                .map( retorno -> ResponseEntity
                                .status(HttpStatus.OK)
                                .body(new Respuesta(
                                    "200",
                                    "Entidad Actualizada",
                                    retorno)
                                )
          );
    }

    @DeleteMapping("/byId/{id}")
    public Mono<ResponseEntity<Respuesta>> delete(@PathVariable
        @NotNull(message = "El id es obligatorio")
        @Positive(message = "El id debe ser mayor que cero")
        @Max(value = 9999999, message = "El id supera el máximo permitido")
         Long id) {
        return objetoService.delete(id)
                .map( retorno -> ResponseEntity
                                .status(HttpStatus.OK)
                                .body(new Respuesta(
                                    "200",
                                    "Entidad eliminada",
                                    retorno)
                                )
          );
    }
}