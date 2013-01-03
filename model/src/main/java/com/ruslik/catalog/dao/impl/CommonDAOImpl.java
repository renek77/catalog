package com.ruslik.catalog.dao.impl;

import com.ruslik.catalog.dao.CommonDAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class CommonDAOImpl implements CommonDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void persist(Object obj) {
        persist(obj, false);
    }

    @Override
    public void persist(Object obj, boolean flush) {
        em.persist(obj);
        if (flush) {
            em.flush();
        }
    }

    @Override
    public <T> T find(Class<T> entityClass, Object id) {
        return em.find(entityClass, id);
    }

    @Override
    public void remove(Class<?> entityClass, Object primaryKey) {
        Object entity = em.getReference(entityClass, primaryKey);
        em.remove(entity);
        em.flush();
    }

    @Override
    public void remove(Object entity) {
        em.remove(entity);
    }

    @Override
    public void flush() {
        em.flush();
    }

    @Override
    public void refresh(Object entity) {
        em.refresh(entity);
    }

    protected <T> T getSingleResult(TypedQuery<T> query) {
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Gets em.
     *
     * @return Value of em.
     */
    public EntityManager getEm() {
        return em;
    }
}
