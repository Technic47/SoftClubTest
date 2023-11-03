package com.softClub.Test.services.abstracts;

import com.softClub.Test.models.AbstractEntity;
import com.softClub.Test.repositories.AbstractRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public abstract class AbstractService<E extends AbstractEntity,
        R extends AbstractRepository<E>>
implements CommonService<E>{
    private final R repository;


    public AbstractService(R repository) {
        this.repository = repository;
    }

    public E save(E entity) {
        return repository.save(entity);
    }

    public List<E> saveAll(Collection<E> batch){
        return repository.saveAll(batch);
    }

    public E getById(Long id) {
        Optional<E> byId = repository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("Record with id: " + id + " not found");
        } else return byId.get();
    }

    public boolean existById(Long id) {
        return repository.existsById(id);
    }

    public Collection<E> getAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        if (!existById(id)) {
            throw new RuntimeException("Record with id: " + id + " not found");
        } else repository.deleteById(id);
    }
}
