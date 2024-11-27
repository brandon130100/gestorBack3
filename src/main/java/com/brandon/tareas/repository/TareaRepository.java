package com.brandon.tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.brandon.tareas.model.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long>, JpaSpecificationExecutor<Tarea> {
}
