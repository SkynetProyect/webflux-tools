package com.graalvm.compilationtest.service;

import org.springframework.stereotype.Component;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import com.graalvm.compilationtest.excepciones.DatosInvalidosException;
import reactor.core.publisher.Mono;

@Component
public class ValidatorGeneral{
    /* Inicia seccion de validaciones de ID */
    public Mono<Void> validarId(Long id, String clase, String metodo){
        if(id == null){
            return Mono.error(
                new DatosInvalidosException(
                    "S_EDI_ID01", // Servicio excepcion dato invalido entrada nula
                    "El id no puede ser nulo",
                    "Long id",
                    clase,
                    metodo
                )
            );
        }
        if(id < 1){
            return Mono.error(
                new DatosInvalidosException(
                    "S_EDI_ID02", // Servicio excepcion dato invalido entrada negativa
                    "El id no puede ser negativo",
                    "Long id",
                    clase,
                    metodo
                )
            );
        }
        if(id > Long.MAX_VALUE){
            return Mono.error(
                new DatosInvalidosException(
                    "S_EDI_ID03", // Servicio excepcion dato invalido entrada supera capacidad de memoria del dato
                    "El id no puede superar 9,223,372,036,854,775,807",
                    "Long id",
                    clase,
                    metodo
                )
            );
        }
        return Mono.empty();
    }
    public Mono<Void> validarAusenciaId(Long id, String clase, String metodo){
        if(id != null){
            return Mono.error(
                new DatosInvalidosException(
                    "S_EDI_ID04", // Servicio excepcion no debe existir dato
                    "El id debe ser nulo",
                    "Long ",
                    clase,
                    metodo
                )
            );
        }
        return Mono.empty();
    }
    /* Inicia seccion de validaciones de texto */
    private static final Pattern SQL_SUSPICIOUS =
        Pattern.compile(
            "(?i)(\\b(select|insert|update|delete|drop|alter|create|truncate|exec|union)\\b|--|;|'|/\\*|\\*/)");

    public Mono<Void> validarNulidadTexto(String texto, String clase, String metodo){
        if(texto == null || texto.isBlank()){
            return Mono.error(
                new DatosInvalidosException(
                    "S_EDI_S01", // excepcion el texto no debe ser nulo
                    "El texto no puede ser nulo",
                    "String ",
                    clase,
                    metodo
                )
            );
        }
        return Mono.empty();
    }
    public Mono<Void> validarLongitudTexto(String texto, String clase, String metodo, long maximo){
        if(texto.length() > maximo){
            return Mono.error(
                new DatosInvalidosException(
                    "S_EDI_S02", // excepcion el texto supera la capacidad permitida
                    "El texto no puede tener mas de "+maximo+" caracteres",
                    "String ",
                    clase,
                    metodo
                )
            );
        } 
        return Mono.empty();
    }
    public Mono<Void> validarAlfaNumTexto(String texto, String clase, String metodo){
        if(!texto.matches("^[a-zA-Z0-9]+$")){
            return Mono.error(
                new DatosInvalidosException(
                    "S_EDI_S03", // excepcion solo se permiten letras y numeros
                    "El texto no puede contener caracteres especiales ",
                    "String ",
                    clase,
                    metodo
                )
            );
        }
        return Mono.empty();
    }
    public Mono<Void> validarNumeroCelular(
            String texto,
            String clase,
            String metodo) {
        if(!texto.matches("^\\+?[0-9]+$")) {
            return Mono.error(
                new DatosInvalidosException(
                    "S_EDI_S04",
                    "El número celular solo debe contener números",
                    "String ",
                    clase,
                    metodo
                )
            );
        }

        return Mono.empty();
    }
    public Mono<Void> validarCorreo(
            String texto,
            String clase,
            String metodo) {
        if(!texto.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            return Mono.error(
                new DatosInvalidosException(
                    "S_EDI_S04",
                    "Debe tener un formato de correo valido",
                    "String ",
                    clase,
                    metodo
                )
            );
        }

        return Mono.empty();
    }
    public Mono<Void> validarTextOnlyTexto(String texto, String clase, String metodo){
        if(!texto.matches("^[a-zA-Z]+$")){
            return Mono.error(
                new DatosInvalidosException(
                    "S_EDI_S05", // excepcion solo deben ingresar letras
                    "El texto no puede contener solo letras ",
                    "String ",
                    clase,
                    metodo
                )
            );
        }
        return Mono.empty();
    }
    public Mono<Void> validarInyeccionSqlTexto(String texto, String clase, String metodo){
        if(SQL_SUSPICIOUS.matcher(texto).find()){
            return Mono.error(
                new DatosInvalidosException(
                    "S_EDI_S06", // excepcion posible inyeccion sql
                    "El texto contiene datos invalidos",
                    "String ",
                    clase,
                    metodo
                )
            );
        }
        return Mono.empty();
    }
    /* Inicia seccion de validaciones de boleans */
    public Mono<Void> validarNulidadBoolean(Boolean condicion, String clase, String metodo){
        if(condicion == null ){
            return Mono.error(
                new DatosInvalidosException(
                    "S_EDI_B01", // excepcion el texto no debe ser nulo
                    "El boolean no puede ser nulo",
                    "Boolean ",
                    clase,
                    metodo
                )
            );
        }
        return Mono.empty();
    }
    /* Inicia seccion de validaciones de integers */
    public Mono<Void> validarNulidadInteger(Integer numero, String clase, String metodo){
        if(numero == null){
            return Mono.error(
                new DatosInvalidosException(
                    "S_EDI_N01", // Servicio excepcion dato invalido entrada nula
                    "El numero no puede ser nulo",
                    "Integer ",
                    clase,
                    metodo
                )
            );
        }
        return Mono.empty();
    }
    public Mono<Void> validarNegativoInteger(Integer numero, String clase, String metodo){
        if(numero < 0){
            return Mono.error(
                new DatosInvalidosException(
                    "S_EDI_N02", // Servicio excepcion dato invalido entrada negativa
                    "El numero no puede ser negativo",
                    "Integer ",
                    clase,
                    metodo
                )
            );
        }
        return Mono.empty();
    }
    public Mono<Void> validarMaxInteger(Integer numero, String clase, String metodo, Integer maximo){
        if(numero > maximo){
            return Mono.error(
                new DatosInvalidosException(
                    "S_EDI_N03", // Servicio excepcion dato invalido entrada supera capacidad de memoria del dato
                    "El numero no puede superar "+maximo,
                    "Integer ",
                    clase,
                    metodo
                )
            );
        }
        return Mono.empty();
    }
}