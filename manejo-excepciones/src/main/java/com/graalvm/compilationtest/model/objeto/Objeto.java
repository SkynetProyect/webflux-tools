package com.graalvm.compilationtest.model.objeto;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;

@Table("objeto")
public class Objeto implements ObjetoInterface{

    @Id
    private Long id;

    @Column("nombre")
    private String nombre;

    public Objeto() {
    }

    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public Objeto setId(Long id) {
        this.id = id;
        return this;
    }

    public Objeto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    
    @Override
    public String toXML() {
        return "<Objeto>" +
            "<id>" + id + "</id>" +
            "<nombre>" + nombre + "</nombre>" +
            "</Objeto>";
    }

}