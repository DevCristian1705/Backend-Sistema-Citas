package com.sisCitas.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class DiasAtencionDto {

    private Long iddiasatencion;
    private Long idusuariodoctor;
    private String diaatencion;
    private String nombredia;

}
