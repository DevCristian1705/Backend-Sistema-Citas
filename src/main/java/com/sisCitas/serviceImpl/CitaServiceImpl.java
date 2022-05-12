package com.sisCitas.serviceImpl;

import com.sisCitas.persistence.entity.Cita;
import com.sisCitas.persistence.entity.Doctor;
import com.sisCitas.persistence.repository.CitaRepository;
import com.sisCitas.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
}
