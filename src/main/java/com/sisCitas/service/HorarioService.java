package com.sisCitas.service;

import com.sisCitas.dto.HorariosDoctorDto;
import com.sisCitas.persistence.entity.Horario;

import java.util.List;

public interface HorarioService {
    Horario save(Horario usuario);
    Horario update(Horario usuario);
    List<Horario> ListAll();
    Long delete(Long idhorario);
    List<HorariosDoctorDto> obtenerHorariosPorIdDoctor (Long iddoctor);
}
