package com.example.demo.service;

import com.example.demo.exception.EntityNotFoundExceptionSupplier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericService<R extends JpaRepository<E, Long>, E, M> implements ServiceInterface<M> {
    @Autowired
    protected R repository;
    @Autowired
    protected ModelMapper modelMapper;
    protected final EntityNotFoundExceptionSupplier exceptionSupplier;
    private final Class<E> entityClass;
    private final Class<M> modelClass;

    public GenericService(Class<E> entityClass, Class<M> modelClass) {
        this.entityClass = entityClass;
        this.modelClass = modelClass;
        this.exceptionSupplier = new EntityNotFoundExceptionSupplier(modelClass.getSimpleName());
    }

    @Override
    public void save(M model) {
        E entity = modelMapper.map(model, entityClass);
        repository.save(entity);
    }

    @Override
    public M get(Long id) {
        E entity = repository.findById(id).orElseThrow(exceptionSupplier.setId(id));
        return modelMapper.map(entity, modelClass);
    }

    @Override
    public List<M> getAll() {
        List<E> entities = repository.findAll();
        return entities
                .stream()
                .map(entity -> modelMapper.map(entity, modelClass))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw exceptionSupplier.setId(id).get();
        }
    }
}
