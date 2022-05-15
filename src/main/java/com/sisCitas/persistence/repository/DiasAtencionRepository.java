package com.sisCitas.persistence.repository;

import com.sisCitas.persistence.entity.DiasAtencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiasAtencionRepository extends JpaRepository<DiasAtencion, Long> {
    List<DiasAtencion> findAllByIdusuariodoctor(Long idusuariodoctor);
}
