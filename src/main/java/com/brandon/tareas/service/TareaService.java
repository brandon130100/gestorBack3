package com.brandon.tareas.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.brandon.tareas.model.Tarea;
import com.brandon.tareas.repository.TareaRepository;

import jakarta.persistence.criteria.Predicate;

@Service
public class TareaService implements TareaRepository {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllInBatch(Iterable<Tarea> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public <S extends Tarea> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Tarea> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Tarea getById(Long arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Tarea getOne(Long arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Tarea getReferenceById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Tarea> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Tarea> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    @Override
    public List<Tarea> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Tarea> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(Tarea entity) {
        tareaRepository.delete(entity);        
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll(Iterable<? extends Tarea> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Long id) {
        tareaRepository.deleteById(id);        
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Optional<Tarea> findById(Long id) {
        return tareaRepository.findById(id);
    }

    @Override
    public <S extends Tarea> S save(S entity) {
        return tareaRepository.save(entity);
    }

    @Override
    public List<Tarea> findAll(Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Tarea> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Tarea> long count(Example<S> example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <S extends Tarea> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <S extends Tarea> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Tarea, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Tarea> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    
    public List<Tarea> filtrarTareas(Long prioridadId, Long responsableId, Long estadoId, Long proyectoId, LocalDate fechaCierre, LocalDate fechaRegistro, String ordenamiento) {
        return tareaRepository.findAll(getSpecifications(prioridadId, responsableId, estadoId, proyectoId, fechaCierre, fechaRegistro, ordenamiento));
    }

    private Specification<Tarea> getSpecifications(Long prioridadId, Long responsableId, Long estadoId, Long proyectoId, LocalDate fechaCierre, LocalDate fechaRegistro, String ordenamiento) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (prioridadId != null) {
                predicates.add(criteriaBuilder.equal(root.get("prioridad").get("id"), prioridadId));
            }
            if (responsableId != null) {
                predicates.add(criteriaBuilder.equal(root.get("responsable").get("id"), responsableId));
            }
            if (estadoId != null) {
                predicates.add(criteriaBuilder.equal(root.get("estado").get("id"), estadoId));
            }
            if (proyectoId != null) {
                predicates.add(criteriaBuilder.equal(root.get("proyecto").get("id"), proyectoId));
            }
            if (fechaCierre != null) {
                predicates.add(criteriaBuilder.equal(root.get("fechaCierre"), fechaCierre));
            }
            if (fechaRegistro != null) {
                predicates.add(criteriaBuilder.equal(root.get("fechaRegistro"), fechaRegistro));
            }

            if (ordenamiento != null){
                switch (ordenamiento){
                    case "fechaCierre":
                        query.orderBy(criteriaBuilder.asc(root.get("fechaCierre")));
                        break;
                    case "prioridad":
                        query.orderBy(criteriaBuilder.asc(root.get("prioridad")));
                        break;
                    case "responsable":
                        query.orderBy(criteriaBuilder.asc(root.get("responsable")));
                        break;
                    case "estado":
                        query.orderBy(criteriaBuilder.asc(root.get("estado")));
                        break;
                    case "proyecto":
                        query.orderBy(criteriaBuilder.asc(root.get("proyecto")));
                        break;
                    default:
                        break;
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    @Override
    public long count(@Nullable Specification<Tarea> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public long delete(@Nullable Specification<Tarea> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public boolean exists(Specification<Tarea> spec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public List<Tarea> findAll(@Nullable Specification<Tarea> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Page<Tarea> findAll(@Nullable Specification<Tarea> arg0, Pageable arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<Tarea> findAll(@Nullable Specification<Tarea> arg0, Sort arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends Tarea, R> R findBy(Specification<Tarea> spec,
            Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }

    @Override
    public Optional<Tarea> findOne(Specification<Tarea> spec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    
}
