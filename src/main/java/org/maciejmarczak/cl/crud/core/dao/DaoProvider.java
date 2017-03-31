package org.maciejmarczak.cl.crud.core.dao;

import java.util.List;

public interface DaoProvider {
    void save(Object entity);
    void update(Object entity);
    void delete(Object entity);
    <T> T findById(Class<T> clazz, long id);
    <T> List<T> findAll(Class<T> clazz);
}
