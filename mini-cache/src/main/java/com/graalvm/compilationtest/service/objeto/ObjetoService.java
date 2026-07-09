package com.graalvm.compilationtest.service.objeto;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Service;

import com.graalvm.compilationtest.model.objeto.Objeto;
import com.graalvm.compilationtest.repository.ObjetoCache;
import com.graalvm.compilationtest.repository.ObjetoRepository;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class ObjetoService implements ObjetoServiceInterface{
    private final ObjetoCache objetoCache;
    private final ObjetoRepository objetoRepository;

    public ObjetoService(ObjetoRepository objetoRepository){
        this.objetoRepository = objetoRepository;
        this.objetoCache = ObjetoCache.getInstance();
    }

    @Override
    public Mono<Objeto> create(Objeto objeto) {

        return objetoRepository.save(objeto)
            .doOnNext(guardado -> 
                objetoCache.agregar(guardado.getId(), guardado.getNombre()))
            .onE;
    }
    
    @Override
    public Mono<Objeto> readById(Long id){

        return objetoCache.buscarId(id)
            .flatMap( identificador -> {
                if(identificador<0){
                    System.out.println(identificador);
                    return objetoRepository.findById(id)
                        .doOnNext(guardado -> 
                        objetoCache.agregar(guardado.getId(), guardado.getNombre()));
                }
                System.out.println("ENCONTRADO ID EN CACHE");
                return Mono.just(new Objeto()
                    .setId(objetoCache.getId(identificador))
                    .setNombre(new String(objetoCache.getNombre(identificador), StandardCharsets.UTF_8)));
            });
    }
    
    @Override
    public Flux<Objeto> readAll() {
        return objetoCache.size().flatMapMany(
            cantidad -> {
                if(cantidad==0){
                    
                    return objetoRepository.findAll()
                        .doOnNext(guardado ->
                            objetoCache.agregar(guardado.getId(), guardado.getNombre())
                        );
                };
                System.out.println("Cache get All "+cantidad);
                return  Flux.fromIterable(objetoCache.indexIds.values())
                .map(indice ->
                    new Objeto()
                        .setId(objetoCache.getId(indice))
                        .setNombre(new String(
                            objetoCache.getNombre(indice),
                            StandardCharsets.UTF_8
                        ))
                );
            });
    }

    
    @Override
    public Mono<Objeto> update(Objeto objeto){
        return objetoCache.buscarId(objeto.getId())
            .doOnNext( identificador -> {
                if(identificador != -1){
                    objetoCache.deleteById(objeto.getId());
                    objetoCache.agregar(objeto.getId(), objeto.getNombre());
                }               
            })
            .flatMap(ignorar -> objetoRepository.save(objeto));

    }
    
    @Override
    public Mono<Boolean> delete(Long id) {
        return objetoRepository.existsById(id)
                .flatMap(exists -> {
                    objetoCache.deleteById(id);
                    if (!exists) {
                        return Mono.just(false);
                    }
                    return objetoRepository.deleteById(id)
                            .thenReturn(true);
                });
    }
}
