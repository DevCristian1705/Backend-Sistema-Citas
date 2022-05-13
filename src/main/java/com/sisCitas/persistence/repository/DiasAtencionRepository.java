package com.sisCitas.persistence.repository;

import com.sisCitas.persistence.entity.DiasAtencion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DiasAtencionRepository extends JpaRepository<DiasAtencion, Long> {
    List<DiasAtencion> findAllByIdusuario(Long idusuario);

}
