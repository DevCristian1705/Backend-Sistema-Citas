package com.sisCitas.dto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@Builder
public class HorariosDoctorDto {
    private Long idusuario;
    private String nombres;
    private Long idhorario;
    private LocalTime horainicio;
    private LocalTime horafin;
    private Boolean isdiponible;
}
