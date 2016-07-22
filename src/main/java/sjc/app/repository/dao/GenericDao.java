package sjc.app.repository.dao;

import sjc.app.entity.AbstractPersistable;

import java.util.List;

public interface GenericDao<T extends AbstractPersistable> {
	
	T save(T obj);
	
	void update(T obj);
	
	List<T> findAll();
	
	T findById(long id);
	
	void delete(long id);
	
	void delete(T obj);
}

