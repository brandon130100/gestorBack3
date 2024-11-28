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

import com.brandon.tareas.model.Departamento;
import com.brandon.tareas.service.DepartamentoService;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoREST {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> filtrarDepartamentos(
            @RequestParam(required = false) String ordenamiento){

        List<Departamento> departamentosFiltrados = departamentoService.filtrarDepartamentos(ordenamiento);
        return ResponseEntity.ok(departamentosFiltrados);
    }

    @PostMapping
    private ResponseEntity<Departamento> saveDepartamento(@RequestBody Departamento departamento){
        try{
            Departamento departamentoGuardado = departamentoService.save(departamento);
            return ResponseEntity.created(new URI("/departamentos/"+departamentoGuardado.getId())).body(departamentoGuardado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Void> deleteDepartamento(@PathVariable("id") Long id){
        try {
            departamentoService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(value = "{id}")
    private ResponseEntity<Departamento> updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamento){
        try {
            Departamento departamentoExistente = departamentoService.findById(id).orElseThrow(() -> new RuntimeException("Departamento no encontrado con el id: " + id));

            departamentoExistente.setNombre(departamento.getNombre());

            Departamento departamentoActual = departamentoService.save(departamentoExistente);
            return ResponseEntity.ok(departamentoActual);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
