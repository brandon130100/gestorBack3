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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brandon.tareas.model.Responsable;
import com.brandon.tareas.service.ResponsableService;

@RestController
@RequestMapping("/responsables")
public class ResponsableREST {

    @Autowired
    private ResponsableService responsableService;

    @GetMapping
    public ResponseEntity<List<Responsable>> filtrarResponsables(
            @RequestParam(required = false) Long departamentoId,
            @RequestParam(required = false) Long puestoId,
            @RequestParam(required = false) String ordenamiento){

        List<Responsable> responsablesFiltrados = responsableService.filtrarResponsable(departamentoId, puestoId, ordenamiento);
        return ResponseEntity.ok(responsablesFiltrados);
    }

    @PostMapping
    private ResponseEntity<Responsable> saveResponsable(@RequestBody Responsable responsable){
        try {
            Responsable responsableGuardado = responsableService.save(responsable);
            return ResponseEntity.created(new URI("/responsables/"+responsableGuardado.getId())).body(responsableGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Void> deleteResponsable(@PathVariable ("id") Long id){
        try{
            responsableService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping (value="{id}")
    private ResponseEntity<Responsable> updateResponsable(@PathVariable Long id, @RequestBody Responsable responsable){
        try {
            Responsable responsableExistente = responsableService.findById(id).orElseThrow(() -> new RuntimeException("Responsable no encontrado con el id: " + id));
            
            responsableExistente.setNombre(responsable.getNombre());
            responsableExistente.setApellido(responsable.getApellido());
            responsableExistente.setCorreo(responsable.getCorreo());
            responsableExistente.setCelular(responsable.getCelular());
            responsableExistente.setDepartamento(responsable.getDepartamento());
            responsableExistente.setPuesto(responsable.getPuesto());

            Responsable responsableActual = responsableService.save(responsableExistente);
            return ResponseEntity.ok(responsableActual);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
