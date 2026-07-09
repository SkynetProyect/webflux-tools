
package com.graalvm.compilationtest.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.graalvm.compilationtest.dto.respuesta.Respuesta;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DatosInvalidosException.class)
    public ResponseEntity<Respuesta> datosInvalidos(
            DatosInvalidosException error) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new Respuesta(
                        error.getCodigo(),
                        error.getMessage(),
                        error.getClase()+"-"+error.getMetodo()
                ));
    }

    @ExceptionHandler(SqlTransactionException.class)
    public ResponseEntity<Respuesta> errorBaseDatos(
            SqlTransactionException error) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new Respuesta(
                        error.getCodigo(),
                        error.getMessage(),
                        error.getClase()+"-"+error.getMetodo()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Respuesta> errorGenerico(
            Exception e) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Respuesta(
                        "Error general",
                        "Error interno del servidor",
                        null
                ));
    }
}