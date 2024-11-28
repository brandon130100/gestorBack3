package com.brandon.tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.brandon.tareas.model.Puesto;

public interface PuestoRepository extends JpaRepository<Puesto, Long>, JpaSpecificationExecutor<Puesto> {

}
