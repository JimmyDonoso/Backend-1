package com.example.proyectoClinica.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String dni;
    private String fechaDeIngreso;
}
