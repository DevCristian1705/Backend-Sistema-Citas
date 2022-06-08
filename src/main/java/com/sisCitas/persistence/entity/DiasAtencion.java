package com.sisCitas.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sisCitas.utils.Auditoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "diasatencion")
public class DiasAtencion  extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddiasatencion;
    private Long idusuariodoctor;
    private LocalDate diaatencion;
    private String nombredia;
    private Date horainicio;
    private Date horafin;

    @JsonIgnore
    private Boolean isactivo;
}
