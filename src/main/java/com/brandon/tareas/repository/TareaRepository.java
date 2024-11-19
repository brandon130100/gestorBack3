package com.brandon.tareas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.brandon.tareas.model.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long>, JpaSpecificationExecutor<Tarea> {
    List<Tarea> findByPrioridadId(Long prioridadId);
    List<Tarea> findByResponsableId(Long responsableId);
    List<Tarea> findByEstadoId(Long estadoId);
    List<Tarea> findByPrioridadIdAndResponsableId(Long prioridadId, Long responsableId);
    List<Tarea> findByPrioridadIdAndEstadoId(Long prioridadId, Long estadoId);
    List<Tarea> findByResponsableIdAndEstadoId(Long responsableId, Long estadoId);
    List<Tarea> findByPrioridadIdAndResponsableIdAndEstadoId(Long prioridadId, Long responsableId, Long estadoId);
}
