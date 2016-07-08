package sjc.app.repository.hibernate;

import org.hibernate.criterion.Criterion;
import sjc.app.repository.base.GenericDao;

import java.util.List;

public interface HibernateDao<T> extends GenericDao<T> {
	
	List<T> findByCriteria(Criterion criterion);

}
