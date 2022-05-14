package com.sisCitas.service;

import com.sisCitas.persistence.entity.DiasAtencion;

import java.util.List;

public interface DiasAtencionService {
    boolean save(List<DiasAtencion> diasAtencion);
    List<DiasAtencion> update(DiasAtencion diasAtencion);
    List<DiasAtencion> ListAll();
    List<DiasAtencion> findAllByIdusuariodoctor(Long idusuariodoctor);
    Long delete(Long iddiasatencion);
}
