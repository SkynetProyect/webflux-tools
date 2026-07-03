package com.graalvm.compilationtest.service.objeto;

import com.graalvm.compilationtest.model.objeto.Objeto;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public interface ObjetoServiceInterface{
    
    Mono<Objeto> create(Objeto objeto);
    Mono<Objeto> readById(Long id);
    Flux<Objeto> readAll();
    Mono<Objeto> update(Objeto objeto);
    Mono<Boolean> delete(Long id);

}