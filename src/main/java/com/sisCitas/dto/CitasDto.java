package com.sisCitas.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CitasDto {
    private Long idcita;
    private Long idusuario;
    private Long iddiasatencion;
    private Long idestadocita;
    private Long idtipoatencion;
}
