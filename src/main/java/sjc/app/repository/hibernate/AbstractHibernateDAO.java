package sjc.app.repository.hibernate;

import org.hibernate.Criteria;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class AbstractHibernateDAO<T> implements HibernateDao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	protected Class<T> getGenericEntityClass() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	

	@Override
	public long save(T obj) {
		return  (Long) getSession().save(obj);
	}

	@Override
	public void update(T o) {
		getSession().update(o);		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Criteria cr = getSession().createCriteria(this.getGenericEntityClass());
		System.out.println(cr.list().size());
		return (List<T>) cr.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByCriteria(Criterion criterion) {
		Criteria crit = getSession().createCriteria(this.getGenericEntityClass());
		crit.add(criterion);
		return (List<T>) crit.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(long id) {
		return (T) getSession().get(this.getGenericEntityClass(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(long id) {
		T persistentObject = (T) getSession().load(this.getGenericEntityClass(), id);
		try {
			getSession().delete(persistentObject);
		} catch (Exception e) {
			T instance = (T) getSession().merge(persistentObject);
			getSession().delete(instance);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(T persistentObject) {
		try {
			getSession().delete(persistentObject);
		} catch (NonUniqueObjectException e) {
			// in a case of detached object
			T instance = (T) getSession().merge(persistentObject);
			getSession().delete(instance);
		}
	}
}
