package com.example.proyectoClinica.service;

import com.example.proyectoClinica.model.Turno;
import com.example.proyectoClinica.model.TurnoDTO;

import java.util.Collection;

public interface ITurnoService {

    public void crearTurno(TurnoDTO turnoDTO);
    public Collection<TurnoDTO> listadoTurnos();
}
