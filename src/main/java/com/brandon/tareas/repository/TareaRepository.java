package com.brandon.tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandon.tareas.model.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

}
