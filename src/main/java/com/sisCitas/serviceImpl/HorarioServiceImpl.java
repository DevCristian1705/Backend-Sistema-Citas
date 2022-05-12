package com.sisCitas.serviceImpl;

import com.sisCitas.dto.HorariosDoctorDto;
import com.sisCitas.persistence.entity.Horario;
import com.sisCitas.persistence.repository.HorarioRepository;
import com.sisCitas.service.HorarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class HorarioServiceImpl implements HorarioService {
    private final HorarioRepository horarioRepository;

    @Override
    public Horario save(Horario horario) {
        horario.setIsactivo(true);
        return horarioRepository.save(horario);
    }

    @Override
    public Horario update(Horario horario) {
        horario.setIsactivo(true);
        return horarioRepository.save(horario);
    }

    @Override
    public List<Horario> ListAll() {
        return horarioRepository.findAll();
    }


    @Override
    public Long delete(Long idhorario) {
        Long rpta = 0L;
        Horario c = horarioRepository
                .findById(idhorario)
                .orElseThrow(EntityNotFoundException::new);
        c.setIsactivo(false);
        rpta = horarioRepository.save(c) != null ? idhorario : 0L;
        return rpta;
    }

    @Override
    public List<HorariosDoctorDto> obtenerHorariosPorIdDoctor(Long iddoctor) {
        List<HorariosDoctorDto> horarios = new ArrayList<>();
        horarioRepository.obtenerHorariosPorIdDoctor(iddoctor).forEach(item -> {
            HorariosDoctorDto h = HorariosDoctorDto.builder()
                    .iddoctor(Long.parseLong(item[0].toString()))
                    .nombres(item[1].toString())
                    .idhorario(Long.parseLong(item[2].toString()))
                    .horainicio(LocalTime.parse(item[3].toString()))
                    .horafin(LocalTime.parse(item[4].toString()))
                    .isdiponible(Boolean.parseBoolean(item[5].toString()))
                    .build();
            horarios.add(h);
        });
        return horarios;
    }

}
