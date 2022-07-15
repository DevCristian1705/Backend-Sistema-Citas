package com.sisCitas.persistence.repository;

import com.sisCitas.persistence.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GraficosRepository extends JpaRepository<Cita, Long> {
    @Query(
            value = "call GraficoDoctores(:FInicio, :FFin)"
            , nativeQuery = true
    )
    List<Object[]> SPGraficoDoctores(String FInicio, String FFin);

    @Query(
            value = "call GraficoCitas()"
            , nativeQuery = true
    )
    List<Object[]> SPGraficoCitas();

}
