package com.sisCitas.service;

import com.sisCitas.dto.CitasUsuarioDto;
import com.sisCitas.persistence.entity.Cita;

import java.util.List;

public interface CitaService {
    Cita save(Cita cita);
    Cita update(Cita cita);
    List<Cita> ListAll();
    Long delete(Long idcita);
    List<CitasUsuarioDto> obtenerCitasPorIdUsuario (Long idusuario, Long idusuariodoctor);
}
