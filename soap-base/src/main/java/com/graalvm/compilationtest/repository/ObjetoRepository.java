package com.graalvm.compilationtest.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import com.graalvm.compilationtest.model.objeto.Objeto;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetoRepository extends R2dbcRepository<Objeto, Long> {

}