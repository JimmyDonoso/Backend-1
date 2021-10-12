package com.example.proyectoClinica.controller;

import com.example.proyectoClinica.model.OdontologoDTO;
import com.example.proyectoClinica.model.PacienteDTO;
import com.example.proyectoClinica.service.IOdontologoService;
import com.example.proyectoClinica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarOdontologo(@PathVariable long id){
        return odontologoService.buscarOdontologo(id);
    }

    @PutMapping()
    public ResponseEntity<?> actualizarOdonto(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarOdonto(@PathVariable long id){
        odontologoService.buscarOdontologo(id);
        return ResponseEntity.status(HttpStatus.OK).body("El odontologo ha sido eliminado");
    }

    @GetMapping("/listado")
    public Collection<OdontologoDTO> listadoOdontologos(){
        return odontologoService.listarOdontologos();
    }


}
