package cz.uhk.fim.repository.dao.api;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public abstract class AbstractGenericDAO<T> {

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected T getSingleResult(final Query q) {
        q.setMaxResults(1);
        List<T> result = q.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
}
