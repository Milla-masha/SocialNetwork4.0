package sjc.app.repository.dao.impl;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import sjc.app.model.entity.AbstractPersistable;
import sjc.app.repository.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public abstract class GenericDaoImpl<T extends AbstractPersistable> implements GenericDao<T>
{

    private final Class<T> persistentClass;
    @PersistenceContext
    private EntityManager entityManager;

    public GenericDaoImpl(final Class<T> persistentClass)
    {
        this.persistentClass = persistentClass;
    }

    public EntityManager getEntityManager()
    {
        return entityManager;
    }

    @Override
    public T save(T obj) throws ConstraintViolationException
    {
        T savedEntity;
        if (obj.getId() == null)
        {
            savedEntity = getEntityManager().merge(obj);
        } else
        {
            getEntityManager().persist(obj);
            savedEntity = obj;
        }
        return savedEntity;
    }

    @Override
    public void update(T obj)
    {
        this.entityManager.merge(obj);
    }

    @Override
    public List<T> findAll()
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(persistentClass);
        Root<T> rootEntry = cq.from(persistentClass);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = getEntityManager().createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public T findById(Long id)
    {
        return getEntityManager().find(persistentClass, id);
    }

    @Override
    public void delete(Long id)
    {
        getEntityManager().remove(findById(id));
    }

    @Override
    public void delete(T persistentObject)
    {
        getEntityManager().remove(persistentObject);
    }
}
