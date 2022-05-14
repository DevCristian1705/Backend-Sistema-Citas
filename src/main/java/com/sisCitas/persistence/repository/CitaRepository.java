package com.sisCitas.persistence.repository;

import com.sisCitas.persistence.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    @Query(
            value = "call ObtenerCitasPorIdUsuario(:idUsuario,:idUsuarioDoctor)"
            , nativeQuery = true
    )
    List<Object[]> obtenerCitasPorIdUsuario(Long idUsuario, Long idUsuarioDoctor);

}
