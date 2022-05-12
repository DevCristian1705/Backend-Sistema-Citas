package com.sisCitas.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sisCitas.utils.Auditoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "horarios")
public class Horario extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idhorario;
    private Date horainicio;
    private Date horafin;

    @JsonIgnore
    private Boolean isactivo;
}
