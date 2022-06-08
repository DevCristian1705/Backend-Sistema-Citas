package com.sisCitas.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder

public class CitasUsuarioDto {
    private Long idcita;
    private String dni;
    private Long idusuario;
    private String usuario;
    private Long idusuariodoctor;
    private String doctor;
    private String horainicio;
    private String horafin;
    private String tipocita;
    private String estado;
    private LocalDate fechacita;
    private Long iddiasatencion;
}
