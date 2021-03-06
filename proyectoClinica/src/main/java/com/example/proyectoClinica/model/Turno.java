package com.example.proyectoClinica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Turnos")
@Getter @Setter
public class Turno {
    @Id
    @GeneratedValue
    private Long id;
    private String fechaTurno;

    @ManyToOne
    @JoinColumn(name="paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="odontologo_id", nullable = false)
    private Odontologo odontologo;

}
