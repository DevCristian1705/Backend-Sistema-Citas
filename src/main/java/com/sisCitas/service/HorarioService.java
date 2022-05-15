package com.sisCitas.service;

import com.sisCitas.dto.HorariosDoctorDto;
import com.sisCitas.persistence.entity.Horario;

import java.util.List;

public interface HorarioService {
    boolean save(List<Horario> horario);
    Horario update(Horario horario);
    List<Horario> ListAll();
    Long delete(Long idhorario);
    List<HorariosDoctorDto> obtenerHorariosPorIdDoctor (Long idusuario);
}
