package com.brandon.tareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandon.tareas.model.Etiqueta;
import com.brandon.tareas.service.EtiquetaService;

@RestController
@RequestMapping("/etiquetas")
public class EtiquetaREST {

    @Autowired
    private EtiquetaService etiquetaService;

    @GetMapping
    private ResponseEntity<List<Etiqueta>> getAllEtiquetas(){
        return ResponseEntity.ok(etiquetaService.findAll());
    }
}
