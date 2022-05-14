package com.sisCitas.persistence.repository;

import com.sisCitas.persistence.entity.DiasAtencion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;


public interface DiasAtencionRepository extends JpaRepository<DiasAtencion, Long> {
    List<DiasAtencion> findAllByIdusuariodoctor(Long idusuariodoctor);


    // List<DiasAtencion[]> GuardarArrayDiasAtencion(Long idusuariodoctor);

}
