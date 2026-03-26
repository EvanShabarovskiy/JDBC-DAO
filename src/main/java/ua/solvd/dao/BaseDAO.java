package ua.solvd.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<T, K> {
    void create(T entity);
    Optional<T> findById(K id);
    List<T> findAll();
    void update(T entity);
    void delete(K id);
}