package com.sisCitas.serviceImpl;

import com.sisCitas.dto.HorariosDoctorDto;
import com.sisCitas.persistence.entity.DiasAtencion;
import com.sisCitas.persistence.repository.DiasAtencionRepository;
import com.sisCitas.service.DiasAtencionService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiasAtencionServiceImpl implements DiasAtencionService {

    private final DiasAtencionRepository diasAtencionRepository;

    @Override
    public boolean save(List<DiasAtencion> diasAtencion) {
        List<DiasAtencion> list = new ArrayList<>();
        diasAtencion.forEach(item -> {
            item.setIsactivo(true);
            list.add(item);
        });
        return diasAtencionRepository.saveAll(list) != null ? true : false;
    }

    @Override
    public List<DiasAtencion> update(DiasAtencion diasAtencion) {
        return null;
    }

    @Override
    public List<DiasAtencion> ListAll() {
        return diasAtencionRepository.findAll();
    }

    @Override
    public List<DiasAtencion> findAllByIdusuariodoctor(Long idusuariodoctor) {
        return diasAtencionRepository.findAllByIdusuariodoctor(idusuariodoctor);
    }

    @Override
    public Long delete(Long iddiasatencion) {
        Long rpta = 0L;
        DiasAtencion c = diasAtencionRepository
                .findById(iddiasatencion)
                .orElseThrow(EntityNotFoundException::new);
        c.setIsactivo(false);
        rpta = diasAtencionRepository.save(c) != null ? iddiasatencion : 0L;
        return rpta;
    }

    @Override
    public List<HorariosDoctorDto> obtenerHorarios(Long idusuariodoctor) {
        List<HorariosDoctorDto> horarios = new ArrayList<>();
        diasAtencionRepository.obtenerHorarios(idusuariodoctor).forEach(item -> {
            HorariosDoctorDto h = HorariosDoctorDto.builder()
                    .iddiasatencion(Long.parseLong(item[0].toString()))
                    .idusuariodoctor(Long.parseLong(item[1].toString()))
                    .diaatencion(LocalDate.parse(item[2].toString()))
                    .doctor(item[3].toString())
                    .horainicio(item[4].toString())
                    .horafin(item[5].toString())
                    .build();
            horarios.add(h);
        });
        return horarios;
    }

}
