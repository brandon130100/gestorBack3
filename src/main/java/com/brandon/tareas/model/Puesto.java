package com.brandon.tareas.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "puestos")
public class Puesto {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "puesto", cascade = {CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval = true)
    private List<Responsable> responsables = new ArrayList<>();

    public Puesto() {
    }

    public Puesto(String nombre) {
        this.nombre = nombre;
        this.responsables = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
