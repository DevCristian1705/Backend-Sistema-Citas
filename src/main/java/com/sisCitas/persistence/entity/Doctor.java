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
@Table(name = "doctores")
public class Doctor extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddoctor;
    private String colegiatura;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String sexo;
    private String direccion;
    private Integer telefono;
    private String correo;
    private String usuario;
    private String password;
    private boolean isadmin;

    @JsonIgnore
    private boolean isactivo;
}