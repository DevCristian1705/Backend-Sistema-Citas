package com.sisCitas.serviceImpl;

import com.sisCitas.persistence.entity.DiasAtencion;
import com.sisCitas.persistence.repository.DiasAtencionRepository;
import com.sisCitas.service.DiasAtencionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor

public class DiasAtencionServiceImpl implements DiasAtencionService {
        private final DiasAtencionRepository diasAtencionRepository;

        @Override
        public DiasAtencion save(DiasAtencion diasAtencion) {
            diasAtencion.setIsactivo(true);
            return diasAtencionRepository.save(diasAtencion);
        }

        @Override
        public DiasAtencion update(DiasAtencion diasAtencion) {
            diasAtencion.setIsactivo(true);
            return diasAtencionRepository.save(diasAtencion);
        }

        @Override
        public List<DiasAtencion> ListAll() {
            return diasAtencionRepository.findAll();
        }

    @Override
    public List<DiasAtencion> findAllByIdusuario(Long idusuario) {
        return diasAtencionRepository.findAllByIdusuario(idusuario);
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

    }
