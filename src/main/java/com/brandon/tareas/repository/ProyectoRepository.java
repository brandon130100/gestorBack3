package com.brandon.tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandon.tareas.model.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

}
