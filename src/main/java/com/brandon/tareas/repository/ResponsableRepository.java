package com.brandon.tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.brandon.tareas.model.Responsable;

public interface ResponsableRepository extends JpaRepository<Responsable, Long>, JpaSpecificationExecutor<Responsable> {

}
