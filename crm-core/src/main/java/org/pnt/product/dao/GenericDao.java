package org.pnt.product.dao;

import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;

/**
 * Created by Alexander on 09.06.2015.
 */
public abstract class GenericDao<T> {
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

    @Transactional
    public Collection<T> findByQuery(String queryString, Class<T> clazz, Object ... params) {
        TypedQuery<T> query = em.createNamedQuery(queryString, clazz);
        for(int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        return query.getResultList();

    }
}
