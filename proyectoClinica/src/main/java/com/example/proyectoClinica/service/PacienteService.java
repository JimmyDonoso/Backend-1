package com.example.proyectoClinica.service;

import com.example.proyectoClinica.model.Paciente;
import com.example.proyectoClinica.model.PacienteDTO;
import com.example.proyectoClinica.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    public void crearPaciente(PacienteDTO pac){
        Paciente paciente = mapper.convertValue(pac, Paciente.class);
        pacienteRepository.save(paciente);
    }

    public PacienteDTO buscarPaciente(Long id){
        PacienteDTO pacienteDTO = null;
        Optional<Paciente> paciente =  pacienteRepository.findById(id);
        if(paciente.isPresent()){
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    public void modificarPaciente(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
    }

    public void borrarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }

    public Collection<PacienteDTO> listaPacientes(){

        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for (Paciente paciente : pacientes){
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTO;
    }

}
