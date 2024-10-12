package com.brandon.tareas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandon.tareas.model.Proyecto;
import com.brandon.tareas.service.ProyectoService;

@RestController
@RequestMapping("/proyectos")
public class ProyectoREST {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    private ResponseEntity<List<Proyecto>> getAllProyectos(){
        return ResponseEntity.ok(proyectoService.findAll());
    }

    @PostMapping
    private ResponseEntity<Proyecto> saveProyecto(@RequestBody Proyecto proyecto){
        try{
            Proyecto proyectoGuardado = proyectoService.save(proyecto);
            return ResponseEntity.created(new URI("/proyectos/"+proyectoGuardado.getId())).body(proyectoGuardado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Void> deleteResponsable(@PathVariable("id") Long id){
        try {
            proyectoService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping (value = "{id}")
    private ResponseEntity<Proyecto> updateProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto){
        try{
            Proyecto proyectoExistente = proyectoService.findById(id).orElseThrow(() -> new RuntimeException("Proyecto no encontrado con el id: " + id));

            proyectoExistente.setNombre(proyecto.getNombre());
            proyectoExistente.setDescripcion(proyecto.getDescripcion());

            Proyecto proyectoActual = proyectoService.save(proyectoExistente);
            return ResponseEntity.ok(proyectoActual);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
