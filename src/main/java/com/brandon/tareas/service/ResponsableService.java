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
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.brandon.tareas.model.Responsable;
import com.brandon.tareas.repository.ResponsableRepository;

import jakarta.persistence.criteria.Predicate;

@Service
public class ResponsableService implements ResponsableRepository {

    @Autowired
    private ResponsableRepository responsableRepository;

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllInBatch(Iterable<Responsable> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public <S extends Responsable> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Responsable> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Responsable getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Responsable getOne(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Responsable getReferenceById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Responsable> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Responsable> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Responsable> findAll() {
        return responsableRepository.findAll();
    }

    @Override
    public List<Responsable> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Responsable> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(Responsable entity) {
        responsableRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll(Iterable<? extends Responsable> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Long id) {
        responsableRepository.deleteById(id);
        
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Optional<Responsable> findById(Long id) {
        return responsableRepository.findById(id);
    }

    @Override
    public <S extends Responsable> S save(S entity) {
        return responsableRepository.save(entity);
    }

    @Override
    public List<Responsable> findAll(Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Responsable> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Responsable> long count(Example<S> example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <S extends Responsable> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <S extends Responsable> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Responsable, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Responsable> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Optional<Responsable> findOne(Specification<Responsable> spec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public List<Responsable> findAll(Specification<Responsable> spec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Page<Responsable> findAll(Specification<Responsable> spec, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<Responsable> findAll(Specification<Responsable> spec, Sort sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public long count(Specification<Responsable> spec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public boolean exists(Specification<Responsable> spec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public long delete(Specification<Responsable> spec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public <S extends Responsable, R> R findBy(Specification<Responsable> spec,
            Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }

    public List<Responsable> filtrarResponsable(Long departamentoId, Long puestoId, String ordenamiento){
        return responsableRepository.findAll(getSpecifications(departamentoId, puestoId, ordenamiento));
    }

    private Specification<Responsable> getSpecifications(Long departamentoId, Long puestoId, String ordenamiento) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (departamentoId != null) {
                predicates.add(criteriaBuilder.equal(root.get("departamento").get("id"), departamentoId));
            }
            if (puestoId != null) {
                predicates.add(criteriaBuilder.equal(root.get("puesto").get("id"), puestoId));
            }

            if (ordenamiento != null){
                switch (ordenamiento){
                    case "departamento":
                        query.orderBy(criteriaBuilder.asc(root.get("departamento")));
                        break;
                    case "puesto":
                        query.orderBy(criteriaBuilder.asc(root.get("puesto")));
                        break;
                    default:
                        break;
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
    
}
