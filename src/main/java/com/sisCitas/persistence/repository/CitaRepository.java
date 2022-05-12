package com.sisCitas.persistence.repository;

import com.sisCitas.persistence.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}
