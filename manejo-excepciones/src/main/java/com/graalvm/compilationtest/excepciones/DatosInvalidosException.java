package com.graalvm.compilationtest.excepciones;

public class DatosInvalidosException extends RuntimeException {

    private final String codigo;
    private final String campo;
    private final String clase;
    private final String metodo;


    public DatosInvalidosException(
            String codigo,
            String mensaje,
            String campo,
            String clase,
            String metodo) {

        super(mensaje);
        this.codigo = codigo;
        this.campo = campo;
        this.clase = clase;
        this.metodo = metodo;
    }


    public String getCodigo() {
        return codigo;
    }
    public String getClase(){
        return clase;
    }
    public String getMetodo(){
        return metodo;
    }
    public String getCampo() {
        return campo;
    }
}