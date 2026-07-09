package com.graalvm.compilationtest.service.objeto;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;
import com.graalvm.compilationtest.model.objeto.Objeto;
import com.graalvm.compilationtest.repository.ObjetoRepository;
import com.graalvm.compilationtest.service.objeto.ValidatorObjeto;
import com.graalvm.compilationtest.service.ValidatorSqlTransaction;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class ObjetoService implements ObjetoServiceInterface{
    private final ValidatorObjeto validador;
    private final ValidatorSqlTransaction validadorsql;
    private final ObjetoRepository objetoRepository;

    public ObjetoService(ObjetoRepository objetoRepository, ValidatorObjeto validador,ValidatorSqlTransaction validadorsql){
        this.objetoRepository = objetoRepository;
        this.validador = validador;
        this.validadorsql = validadorsql;
    }

    @Override
    public Mono<Objeto> create(Objeto objeto) {
        return validador.create(objeto)
            .flatMap(objetoRepository::save)
            .onErrorMap(e -> validadorsql.detectarMotivoError(e,"ObjetoService","create"));
            

    }
    @Override
    public Mono<Objeto> readById(Long id){
        return validador.readById(id)
            .flatMap(objetoRepository::findById)
            .onErrorMap(e -> validadorsql.detectarMotivoError(e,"ObjetoService","readById"));
    }
    @Override
    public Flux<Objeto> readAll() {
        return objetoRepository.findAll()
                .onErrorMap(e -> validadorsql.detectarMotivoError(e,"ObjetoService","readAll"));
    
    }
    @Override
    public Mono<Objeto> update(Objeto objeto){
        return validador.update(objeto) 
            .flatMap(objetoRepository::save)
            .onErrorMap(e -> validadorsql.detectarMotivoError(e,"ObjetoService","update"));
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
                })
            .onErrorMap(e -> validadorsql.detectarMotivoError(e,"ObjetoService","delete"));
    }
}
