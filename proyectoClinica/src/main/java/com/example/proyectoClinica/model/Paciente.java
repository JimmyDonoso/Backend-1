package com.example.proyectoClinica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Pacientes")
@Getter @Setter
public class Paciente {
    @Id
    @GeneratedValue //este es como el autoincrement
    private Long id;
    private String nombre;
    private String dni;
    private String fechaDeIngreso;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore //evitar los ciclos con el mapper
    private Set<Turno> turnos;

}
