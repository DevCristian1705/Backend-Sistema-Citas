package com.sisCitas.persistence.repository;

import com.sisCitas.persistence.entity.DiasAtencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiasAtencionRepository extends JpaRepository<DiasAtencion, Long> {
    List<DiasAtencion> findAllByIdusuariodoctor(Long idusuariodoctor);

    @Query(
            value = "call ObtenerHorariosPorIdDoctor(:IdUsuarioDoctor, :FechaCita)"
            , nativeQuery = true
    )
    List<Object[]> obtenerHorarios(Long IdUsuarioDoctor, String FechaCita);

}
