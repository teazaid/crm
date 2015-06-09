package org.pnt.product.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by Alexander on 09.06.2015.
 */
public class AbstractDao<T> {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public T saveOrUpdate(T object) {
        return em.merge(object);
    }

    @Transactional
    public T find(Long id, Class<T> clazz) {
        return em.find(clazz, id);
    }

    @Transactional
    public void remove(T object) {
        em.remove(object);
    }
}
