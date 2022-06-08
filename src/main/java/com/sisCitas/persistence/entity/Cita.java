package com.sisCitas.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sisCitas.utils.Auditoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "citas")
public class Cita extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcita;
    private Long idusuario;
    private Long iddiasatencion;
    private Long idestadocita;
    private Long idtipocita;

    @JsonIgnore
    private boolean isactivo;
}