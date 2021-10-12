package com.example.proyectoClinica.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class TurnoDTO {
    private Long id;
    private String fechaTurno;
    private Paciente paciente;
    private Odontologo odontologo;
}
