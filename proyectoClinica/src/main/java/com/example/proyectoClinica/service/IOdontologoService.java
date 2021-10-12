package com.example.proyectoClinica.service;

import com.example.proyectoClinica.model.Odontologo;
import com.example.proyectoClinica.model.OdontologoDTO;
import com.example.proyectoClinica.repository.IOdontologoRepository;

import java.util.*;

public interface IOdontologoService {
    public void crearOdontologo(OdontologoDTO odon);

    public OdontologoDTO buscarOdontologo(Long id);

    public void modificarOdontologo(OdontologoDTO odontologoDTO);

    public void borrarOdontologo(Long id);

    public Collection<OdontologoDTO> listarOdontologos();
}
