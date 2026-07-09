package com.graalvm.compilationtest.dto.entrada.objeto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.URL;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public record ObjetoUpdateDto(

        @NotNull(message = "El id es obligatorio")
        @Positive(message = "El id debe ser mayor que cero")
        @Min(value = 1, message = "El id mínimo permitido es 1")
        @Max(value = 9999999, message = "El id máximo permitido es 9999999")
        Long id,

        @NotNull(message = "El nombre es obligatorio")
        @NotBlank(message = "El nombre no puede estar vacío")
        //@Email
        //@URL
        /*@Digits(
            integer = 7,
            fraction = 0,
            message = "Debe ser un número no debe ser fraccionario"
        )*/
        @Size(
            min = 3,
            max = 100,
            message = "El valor debe tener entre 3 y 100 caracteres"
        )
        @Pattern(
            regexp = "^[a-zA-Z]+$",
            message = "Solo se permiten letras"
        )
        String nombre

) {}