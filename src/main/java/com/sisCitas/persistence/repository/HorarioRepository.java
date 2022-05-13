package com.sisCitas.persistence.repository;

import com.sisCitas.persistence.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    @Query(
            value = "call ObtenerHorariosPorIdDoctor(:idUsuario)"
            , nativeQuery = true
    )
    List<Object[]> obtenerHorariosPorIdDoctor(Long idUsuario);
}
