package com.brandon.tareas.controller;

import java.net.URI;
import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brandon.tareas.model.Tarea;
import com.brandon.tareas.service.TareaService;

@RestController
@RequestMapping("/tareas")
public class TareaREST {

    @Autowired
    private TareaService tareaService;


    @GetMapping
    public ResponseEntity<List<Tarea>> filtrarTareas(
            @RequestParam(required = false) Long prioridadId,
            @RequestParam(required = false) Long responsableId,
            @RequestParam(required = false) Long estadoId,
            @RequestParam(required = false) Long proyectoId,
            @RequestParam(required = false) LocalDate fechaCierre,
            @RequestParam(required = false) LocalDate fechaRegistro,
            @RequestParam(required = false) String ordenamiento) {
        
        List<Tarea> tareasFiltradas = tareaService.filtrarTareas(prioridadId, responsableId, estadoId, proyectoId, fechaCierre, fechaRegistro, ordenamiento);
        return ResponseEntity.ok(tareasFiltradas);
    }

    @PostMapping
    private ResponseEntity<Tarea> saveTarea(@RequestBody Tarea tarea){
        try{
            Tarea tareaGuardada = tareaService.save(tarea);
            return ResponseEntity.created(new URI("/tareas/"+tareaGuardada.getId())).body(tareaGuardada);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Void> deleteTarea(@PathVariable("id") Long id) {
        try {
            tareaService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping (value = "{id}")
    private ResponseEntity<Tarea> updateTarea(@PathVariable Long id, @RequestBody Tarea tarea){
        try{
            Tarea tareaExistente = tareaService.findById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada con el id: " + id));

            tareaExistente.setNombre(tarea.getNombre());
            tareaExistente.setPrioridad(tarea.getPrioridad());
            tareaExistente.setResponsable(tarea.getResponsable());
            tareaExistente.setEstado(tarea.getEstado());
            tareaExistente.setFechaCierre(tarea.getFechaCierre());
            tareaExistente.setProyecto(tarea.getProyecto());

            Tarea tareaActual = tareaService.save(tareaExistente);
            return ResponseEntity.ok(tareaActual);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
