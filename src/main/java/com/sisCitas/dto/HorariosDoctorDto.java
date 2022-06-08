package com.sisCitas.dto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
public class HorariosDoctorDto {
    private Long iddiasatencion;
    private Long idusuariodoctor;
    private LocalDate diaatencion;
    private String doctor;
    private String horainicio;
    private String horafin;
}
