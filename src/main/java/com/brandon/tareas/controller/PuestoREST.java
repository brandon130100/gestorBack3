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

import com.brandon.tareas.model.Puesto;
import com.brandon.tareas.service.PuestoService;

@RestController
@RequestMapping("/puestos")
public class PuestoREST {

    @Autowired
    private PuestoService puestoService;

    @GetMapping
    private ResponseEntity<List<Puesto>> getAllPuestos(){
        return ResponseEntity.ok(puestoService.findAll());
    }

    @PostMapping
    private ResponseEntity<Puesto> savePuesto(@RequestBody Puesto puesto){
        try{
            Puesto puestoGuardado = puestoService.save(puesto);
            return ResponseEntity.created(new URI("/puestos/"+puestoGuardado.getId())).body(puestoGuardado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Void> deletePuesto(@PathVariable("id") Long id){
        try {
            puestoService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(value = "{id}")
    private ResponseEntity<Puesto> updatePuesto(@PathVariable Long id, @RequestBody Puesto puesto){
        try {
            Puesto puestoExistente = puestoService.findById(id).orElseThrow(() -> new RuntimeException("Puesto no encontrado con el id: " + id));

            puestoExistente.setNombre(puesto.getNombre());

            Puesto puestoActual = puestoService.save(puestoExistente);
            return ResponseEntity.ok(puestoActual);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
