package com.sisCitas.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder

public class DiasAtencionDto {
    private Long iddiasatencion;
    private Long idusuariodoctor;
    private LocalDate diaatencion;
    private String nombredia;
    private Date horainicio;
    private Date horafin;
}
