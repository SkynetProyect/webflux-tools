package com.graalvm.compilationtest.dto.respuesta;

public record Respuesta (
    String codigo,
    String mensaje,
    Object data
){}