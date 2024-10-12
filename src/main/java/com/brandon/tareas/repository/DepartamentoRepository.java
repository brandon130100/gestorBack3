package com.brandon.tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandon.tareas.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
