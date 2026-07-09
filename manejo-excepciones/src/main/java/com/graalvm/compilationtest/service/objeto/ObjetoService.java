package com.graalvm.compilationtest.service.objeto;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Service;

import com.graalvm.compilationtest.model.objeto.Objeto;
import com.graalvm.compilationtest.repository.ObjetoRepository;
import com.graalvm.compilationtest.service.objeto.ValidatorObjeto;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class ObjetoService implements ObjetoServiceInterface{
    private final ValidatorObjeto validador;
    private final ObjetoRepository objetoRepository;

    public ObjetoService(ObjetoRepository objetoRepository, ValidatorObjeto validador){
        this.objetoRepository = objetoRepository;
        this.validador = validador;
    }

    @Override
    public Mono<Objeto> create(Objeto objeto) {
        return validador.create(objeto)
            .flatMap(objetoRepository::save); 
  
    }
    /*  Ahora falta agregar los posibles errores sql... y los Dto con validaciones
        .onErrorMap(
            DataIntegrityViolationException.class,
            e -> new ObjetoDuplicadoException(
                "El objeto ya existe"
            )
        );
        */


    @Override
    public Mono<Objeto> readById(Long id){
        return validador.readById(id)
            .flatMap(objetoRepository::findById);
    }
    
    @Override
    public Flux<Objeto> readAll() {
        return objetoRepository.findAll();
    }

    
    @Override
    public Mono<Objeto> update(Objeto objeto){
        return validador.update(objeto) 
            .flatMap(objetoRepository::save);
    }
    
    @Override
    public Mono<Boolean> delete(Long id) {
        return validador.delete(id)
            .flatMap(objetoRepository::existsById)
                .flatMap(exists -> {
                    if (!exists) {
                        return Mono.just(false);
                    }
                    return objetoRepository.deleteById(id)
                            .thenReturn(true);
                });
    }
}
