package com.graalvm.compilationtest.service.objeto;

import com.graalvm.compilationtest.repository.ObjetoRepository;
import com.graalvm.compilationtest.model.objeto.Objeto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class ObjetoService implements ObjetoServiceInterface{

    private final ObjetoRepository objetoRepository;

    public ObjetoService(ObjetoRepository objetoRepository){
        this.objetoRepository = objetoRepository;
    }
    @Override
    public Mono<Objeto> create(Objeto objeto){
        return objetoRepository.save(objeto);

    }
    @Override
    public Mono<Objeto> readById(Long id){
        return objetoRepository.findById(id).defaultIfEmpty( new Objeto());
    }

    @Override
    public Flux<Objeto> readAll(){
        return objetoRepository.findAll();

    }
    @Override
    public Mono<Objeto> update(Objeto objeto){
        return objetoRepository.save(objeto);

    }
    @Override
    public Mono<Boolean> delete(Long id) {
        return objetoRepository.existsById(id)
                .flatMap(exists -> {
                    if (!exists) {
                        return Mono.just(false);
                    }
                    return objetoRepository.deleteById(id)
                            .thenReturn(true);
                });
    }
}