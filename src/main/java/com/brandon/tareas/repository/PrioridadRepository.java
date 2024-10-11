package com.brandon.tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandon.tareas.model.Prioridad;

public interface PrioridadRepository extends JpaRepository<Prioridad, Long> {
    
}
