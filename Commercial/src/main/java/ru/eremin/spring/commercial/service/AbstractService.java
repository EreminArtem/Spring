package ru.eremin.spring.commercial.service;

import java.util.List;

public interface AbstractService<T> {

    List<T> findAll();

    List<T> findAll(final int page, final int size);

    T findById(final String id);

    T findByName(final String name);

    void insert(final T object);

    void deleteById(final String id);

    void delete(final T Object);

    void update(final T Object);

    void merge(final T Object);
}
