package com.graalvm.compilationtest.service.objeto;

import com.graalvm.compilationtest.service.ValidatorGeneral;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import com.graalvm.compilationtest.model.objeto.Objeto;

@Component
public class ValidatorObjeto{
    private ValidatorGeneral validador;
    private final String clase = "ObjetoService";

    public ValidatorObjeto( ValidatorGeneral validador){
        this.validador = validador;
    }

    public Mono<Objeto> create(Objeto objeto) {
        String nombreMetodo = "create";

        return validador.validarAusenciaId(objeto.getId(),clase,nombreMetodo)
            .then(validador.validarNulidadTexto(objeto.getNombre(),clase,nombreMetodo))
            .then(validador.validarLongitudTexto(objeto.getNombre(),clase,nombreMetodo,50L))
            .then(validador.validarInyeccionSqlTexto(objeto.getNombre(),clase,nombreMetodo))
            .then(validador.validarTextOnlyTexto(objeto.getNombre(),clase,nombreMetodo))
            .thenReturn(objeto);
    }
    
    public Mono<Long> readById(Long id){
        String nombreMetodo = "readById";
        return validador.validarId(id,clase,nombreMetodo)
            .thenReturn(id);
    }

    public Mono<Objeto> update(Objeto objeto){
        String nombreMetodo = "update";
        return validador.validarId(objeto.getId(),clase,nombreMetodo)
            .then(validador.validarNulidadTexto(objeto.getNombre(),clase,nombreMetodo))
            .then(validador.validarLongitudTexto(objeto.getNombre(),clase,nombreMetodo,50L))
            .then(validador.validarInyeccionSqlTexto(objeto.getNombre(),clase,nombreMetodo))
            .then(validador.validarTextOnlyTexto(objeto.getNombre(),clase,nombreMetodo))
            .thenReturn(objeto);
    }
    
    public Mono<Long> delete(Long id) {
        String nombreMetodo = "delete";
        return validador.validarId(id,clase,nombreMetodo)
                .thenReturn(id);
    }


   
}