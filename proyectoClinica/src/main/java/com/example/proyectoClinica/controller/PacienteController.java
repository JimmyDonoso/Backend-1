package com.example.proyectoClinica.controller;

import com.example.proyectoClinica.model.PacienteDTO;
import com.example.proyectoClinica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPaciente(@PathVariable long id){
        return pacienteService.buscarPaciente(id);
    }

    @PutMapping()
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPaciente(@PathVariable long id){
        pacienteService.borrarPaciente(id);
        return ResponseEntity.status(HttpStatus.OK).body("El paciente ha silo eliminado");
    }

    @GetMapping("/listado")
    public Collection<PacienteDTO> listadoPacientes(){
        return pacienteService.listaPacientes();
    }
}
