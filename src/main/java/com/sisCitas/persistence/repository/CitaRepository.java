package com.sisCitas.persistence.repository;

import com.sisCitas.persistence.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    @Query(
            value = "call ObtenerCitas(:IdUsuario,:IdUsuarioDoctor,:FechaCita)"
            , nativeQuery = true
    )
    List<Object[]> obtenerCitas(Long IdUsuario, Long IdUsuarioDoctor, String FechaCita);

}
