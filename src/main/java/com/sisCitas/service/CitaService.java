package com.sisCitas.service;

import com.sisCitas.dto.CitasDto;
import com.sisCitas.dto.CitasUsuarioDto;
import com.sisCitas.persistence.entity.Cita;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CitaService {
    Cita save(Cita cita);
    Cita update(Cita cita);
    List<Cita> ListAll();
   // Long delete(Long idcita);
    List<CitasUsuarioDto> obtenerCitas (Long idusuario, Long idusuariodoctor, String fechacita);
    boolean saveAll(List<Cita> cita);
}
