package com.brandon.tareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandon.tareas.model.Prioridad;
import com.brandon.tareas.service.PrioridadService;

@RestController
@RequestMapping("/prioridades")
public class PrioridadRest {

    @Autowired
    private PrioridadService prioridadService;

    @GetMapping
    private ResponseEntity<List<Prioridad>> getAllPrioridades(){
        return ResponseEntity.ok(prioridadService.findAll());
    }
}
