package com.graalvm.compilationtest.excepciones;

public class SqlTransactionException extends RuntimeException {

    private final String codigo;
    private final String clase;
    private final String metodo;
    private final String mensaje;

    public SqlTransactionException(String codigo, String message, String clase, String metodo) {
        super(message);
        this.mensaje = message;
        this.clase = clase;
        this.metodo = metodo;
        this.codigo = codigo;
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
    public String getMessage() {
        return mensaje;
    }

}