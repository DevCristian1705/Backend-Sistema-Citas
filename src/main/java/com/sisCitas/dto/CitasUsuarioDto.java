package com.sisCitas.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CitasUsuarioDto {
    private Long idcita;
    private Long idusuario;
    private Long idhorariodoctores;
    private Long iddoctor;
    private String usuario;
    private String doctor;
    private String fecha;
    private String horainicio;
    private String horafin;
    private String tipocita;
    private Boolean isadmin;

}