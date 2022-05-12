package com.sisCitas.service;

import com.sisCitas.persistence.entity.Cita;

import java.util.List;

public interface CitaService {
    Cita save(Cita cita);
    Cita update(Cita cita);
    List<Cita> ListAll();
    Long delete(Long idcita);
}
