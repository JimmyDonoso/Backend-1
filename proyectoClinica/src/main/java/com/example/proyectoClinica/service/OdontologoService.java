package com.example.proyectoClinica.service;

import com.example.proyectoClinica.model.Odontologo;
import com.example.proyectoClinica.model.OdontologoDTO;
import com.example.proyectoClinica.model.Paciente;
import com.example.proyectoClinica.model.PacienteDTO;
import com.example.proyectoClinica.repository.IOdontologoRepository;
import com.example.proyectoClinica.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    public void crearOdontologo(OdontologoDTO odon){
        Odontologo odontologo = mapper.convertValue(odon, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    public OdontologoDTO buscarOdontologo(Long id){
        OdontologoDTO odontologoDTO = null;
        Optional<Odontologo> odontologo =  odontologoRepository.findById(id);
        if(odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    public void modificarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    public void borrarOdontologo(Long id){
        odontologoRepository.deleteById(id);
    }

    public Collection<OdontologoDTO> listarOdontologos(){

        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for (Odontologo odontologo : odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }
}
