package com.sisCitas.service;

import com.sisCitas.persistence.entity.DiasAtencion;

import java.util.List;

public interface DiasAtencionService {
    DiasAtencion save(DiasAtencion diasAtencion);
    DiasAtencion update(DiasAtencion diasAtencion);
    List<DiasAtencion> ListAll();
    List<DiasAtencion> findAllByIdusuario(Long idusuario);
    Long delete(Long iddiasatencion);
}
