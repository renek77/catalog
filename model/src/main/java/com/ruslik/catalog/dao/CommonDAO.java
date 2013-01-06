package com.ruslik.catalog.dao;

public interface CommonDAO {

    void persist(Object obj);

    void persist(Object obj, boolean flush);

    <T> T find(Class<T> entityClass, Object id);

    void remove(Class<?> entityClass, Object primaryKey);

    void remove(Object entity);

    void flush();

    void refresh(Object entity);
}
