package com.sisCitas.serviceImpl;

import com.sisCitas.dto.CitasDto;
import com.sisCitas.dto.CitasUsuarioDto;
import com.sisCitas.persistence.entity.Cita;
import com.sisCitas.persistence.entity.DiasAtencion;
import com.sisCitas.persistence.repository.CitaRepository;
import com.sisCitas.persistence.repository.DiasAtencionRepository;
import com.sisCitas.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CitaServiceImpl  implements CitaService {
    private final CitaRepository citaRepository;
    private final DiasAtencionRepository diasAtencionRepository;

    @Override
    public Cita save(Cita cita) {
        Cita c = new Cita();
        c.setIdcita(cita.getIdcita());
        c.setIdusuario(cita.getIdusuario());
        c.setIddiasatencion(cita.getIddiasatencion());
        c.setIdestadocita(cita.getIdestadocita());
        c.setIdtipocita(cita.getIdtipocita());
        c.setIsactivo(true);
        Cita cm = citaRepository.save(c);

        DiasAtencion da = diasAtencionRepository
                .findById(cm.getIddiasatencion())
                .orElseThrow(EntityNotFoundException::new);
        da.setIsactivo(false);
        diasAtencionRepository.save(da);
        return cm;

      // return citaRepository.save(cita);
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
    public boolean saveAll(List<Cita> cita) {
        List<Cita> c = new ArrayList<>();
        cita.forEach(item -> {
            item.setIsactivo(false);
            c.add(item);

            DiasAtencion da = diasAtencionRepository
                    .findById(item.getIddiasatencion())
                    .orElseThrow(EntityNotFoundException::new);
            da.setIsactivo(true);
            diasAtencionRepository.save(da);
        });
        return citaRepository.saveAll(c) != null ? true : false;
    }

    @Override
    public List<CitasUsuarioDto> obtenerCitas(Long idusuario, Long idusuariodoctor, String fechacita) {
        List<CitasUsuarioDto> citas = new ArrayList<>();
        citaRepository.obtenerCitas(idusuario, idusuariodoctor,fechacita).forEach(item -> {
            CitasUsuarioDto h = CitasUsuarioDto.builder()
                    .idcita(Long.parseLong(item[0].toString()))
                    .dni(item[1].toString())
                    .idusuario(Long.parseLong(item[2].toString()))
                    .usuario(item[3].toString())
                    .idusuariodoctor(Long.parseLong(item[4].toString()))
                    .doctor(item[5].toString())
                    .horainicio(item[6].toString())
                    .horafin(item[7].toString())
                    .tipocita(item[8].toString())
                    .idtipocita(Long.parseLong(item[9].toString()))
                    .estado(item[10].toString())
                    .idestadocita(Long.parseLong(item[11].toString()))
                    .fechacita(LocalDate.parse(item[12].toString()))
                    .iddiasatencion(Long.parseLong(item[13].toString()))
                    .build();
            citas.add(h);
        });
        return citas;
    }

}
