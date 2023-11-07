package com.softClub.Test.services.abstracts;

import java.util.Collection;
import java.util.List;

public interface CommonService<E> {
    E save(E entity);

    List<E> saveAll(Collection<E> batch);

    E getById(Long id);

    boolean existById(Long id);

    Collection<E> getAll();

    void deleteById(Long id);
}
