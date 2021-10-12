package com.example.proyectoClinica.service;

import com.example.proyectoClinica.model.PacienteDTO;

import java.util.Collection;

public interface IPacienteService {

    public void crearPaciente(PacienteDTO pac);
    public PacienteDTO buscarPaciente(Long id);
    public void modificarPaciente(PacienteDTO pacienteDTO);
    public void borrarPaciente(Long id);
    public Collection<PacienteDTO> listaPacientes();
}
