package com.brandon.tareas.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table (name = "tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_prioridad")
    private Prioridad prioridad;

    @ManyToOne
    @JoinColumn(name= "id_responsable")
    private Responsable responsable;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    private LocalDate fechaRegistro;
    private LocalDate fechaCierre;

    @ManyToOne
    @JoinColumn(name= "id_proyecto")
    Proyecto proyecto;


    @PrePersist
    public void prePersist() {
        this.fechaRegistro = LocalDate.now();
    }

    public Tarea() {
    }


    public Tarea(String nombre, Prioridad prioridad, Responsable responsable, Estado estado, LocalDate fechaRegistro,
            LocalDate fechaCierre, Proyecto proyecto) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.responsable = responsable;
        this.estado = estado;
        this.fechaRegistro = LocalDate.now();
        this.fechaCierre = fechaCierre;
        this.proyecto = proyecto;
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


    public Prioridad getPrioridad() {
        return prioridad;
    }


    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }


    public Responsable getResponsable() {
        return responsable;
    }


    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }


    public Estado getEstado() {
        return estado;
    }


    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }


    public void setFechaRegistro() {
        this.fechaRegistro = LocalDate.now();
    }


    public LocalDate getFechaCierre() {
        return fechaCierre;
    }


    public void setFechaCierre(LocalDate fechacierre) {
        this.fechaCierre = fechacierre;
    }


    public Proyecto getProyecto() {
        return proyecto;
    }


    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    } 
}
