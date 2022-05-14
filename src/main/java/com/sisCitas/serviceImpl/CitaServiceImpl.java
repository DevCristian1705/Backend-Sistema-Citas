package com.sisCitas.serviceImpl;

import com.sisCitas.dto.CitasUsuarioDto;
import com.sisCitas.persistence.entity.Cita;
import com.sisCitas.persistence.repository.CitaRepository;
import com.sisCitas.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CitaServiceImpl  implements CitaService {
    private final CitaRepository citaRepository;

    @Override
    public Cita save(Cita cita) {
        cita.setIsactivo(true);
        return citaRepository.save(cita);
    }

    @Override
    public Cita update(Cita cita) {
        cita.setIsactivo(true);
        return citaRepository.save(cita);
    }

    @Override
    public List<Cita> ListAll() {
        return citaRepository.findAll();
    }

    @Override
    public Long delete(Long idcita) {
        Long rpta = 0L;
        Cita c = citaRepository
                .findById(idcita)
                .orElseThrow(EntityNotFoundException::new);
        c.setIsactivo(false);
        rpta = citaRepository.save(c) != null ? idcita : 0L;
        return rpta;
    }

    @Override
    public List<CitasUsuarioDto> obtenerCitasPorIdUsuario(Long idusuario, Long idusuariodoctor) {
        List<CitasUsuarioDto> citas = new ArrayList<>();
        citaRepository.obtenerCitasPorIdUsuario(idusuario, idusuariodoctor).forEach(item -> {
            CitasUsuarioDto h = CitasUsuarioDto.builder()
                    .idcita(Long.parseLong(item[0].toString()))
                    .idusuario(Long.parseLong(item[1].toString()))
                    .idhorariodoctores(Long.parseLong(item[2].toString()))
                    .usuario(item[3].toString())
                    .doctor(item[4].toString())
                    .fecha(item[5].toString())
                    .horainicio(item[6].toString())
                    .horafin(item[7].toString())
                    .tipocita(item[8].toString())
                    .isadmin(Boolean.parseBoolean(item[9].toString()))
                    .build();
            citas.add(h);
        });
        return citas;
    }

}
