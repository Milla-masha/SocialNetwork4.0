package sjc.app.repository.base;

import java.util.List;

public interface GenericDao<T> {
	
	long save(T obj);
	
	void update(T obj);
	
	List<T> findAll();
	
	T findById(long id);
	
	void delete(long id);
	
	void delete(T persistentObject);
}

