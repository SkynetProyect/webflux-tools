
package com.graalvm.compilationtest.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import com.graalvm.compilationtest.dto.respuesta.Respuesta;
import jakarta.validation.ConstraintViolationException;

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

        @ExceptionHandler(ConstraintViolationException.class)
        public ResponseEntity<Respuesta> constraintViolation(
                ConstraintViolationException error) {

        String mensaje = error.getConstraintViolations()
                .stream()
                .map(v -> v.getMessage())
                .reduce("", (a, b) -> a + b + "#");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new Respuesta(
                        "C_II_01", // entrada invalida de un path variable
                        mensaje,
                        null
                ));
        }
        @ExceptionHandler(WebExchangeBindException.class)
        public ResponseEntity<Respuesta> bodyValidation(
                WebExchangeBindException error) {

        String mensaje = error.getFieldErrors()
                .stream()
                .map(e ->
                        e.getField() + ": " + e.getDefaultMessage()
                )
                .reduce("", (a,b) -> a + b + "#");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new Respuesta(
                        "C_II_02", // entrada invalida en un Dto
                        mensaje,
                        null
                ));
        }
/*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Respuesta> errorGenerico(
            Exception e) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Respuesta(
                        "Error general",
                        e,
                        null
                ));
    }
    */
}