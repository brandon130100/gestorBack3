package com.brandon.tareas.service;

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
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.brandon.tareas.model.Proyecto;
import com.brandon.tareas.repository.ProyectoRepository;

import jakarta.persistence.criteria.Predicate;

@Service
public class ProyectoService implements ProyectoRepository {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends Proyecto> S saveAndFlush(S entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends Proyecto> List<S> saveAllAndFlush(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAllInBatch(Iterable<Proyecto> entities) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Proyecto getOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Proyecto getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Proyecto getReferenceById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends Proyecto> List<S> findAll(Example<S> example) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends Proyecto> List<S> findAll(Example<S> example, Sort sort) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends Proyecto> List<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Proyecto> findAll() {
        return proyectoRepository.findAll();
    }

    @Override
    public List<Proyecto> findAllById(Iterable<Long> ids) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends Proyecto> S save(S entity) {
        return proyectoRepository.save(entity);
    }

    @Override
    public Optional<Proyecto> findById(Long id) {
        return proyectoRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteById(Long id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public void delete(Proyecto entity) {
        proyectoRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAll(Iterable<? extends Proyecto> entities) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Proyecto> findAll(Sort sort) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Page<Proyecto> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends Proyecto> Optional<S> findOne(Example<S> example) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends Proyecto> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends Proyecto> long count(Example<S> example) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends Proyecto> boolean exists(Example<S> example) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends Proyecto, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Optional<Proyecto> findOne(Specification<Proyecto> spec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public List<Proyecto> findAll(Specification<Proyecto> spec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Page<Proyecto> findAll(Specification<Proyecto> spec, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<Proyecto> findAll(Specification<Proyecto> spec, Sort sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public long count(Specification<Proyecto> spec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public boolean exists(Specification<Proyecto> spec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public long delete(Specification<Proyecto> spec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public <S extends Proyecto, R> R findBy(Specification<Proyecto> spec,
            Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }

    public List<Proyecto> filtrarProyectos(String ordenamiento) {
        return proyectoRepository.findAll(getSpecifications(ordenamiento));
    }

    private Specification<Proyecto> getSpecifications(String ordenamiento) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (ordenamiento != null) {
                switch (ordenamiento) {
                    case "nombreAsc":
                        query.orderBy(criteriaBuilder.asc(root.get("nombre")));
                        break;
                    case "nombreDesc":
                        query.orderBy(criteriaBuilder.desc(root.get("nombre")));
                        break;
                    default:
                        break;
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    
}
