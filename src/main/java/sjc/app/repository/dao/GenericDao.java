package sjc.app.repository.dao;

import sjc.app.entity.AbstractPersistable;

import java.util.List;

public interface GenericDao<T extends AbstractPersistable> {
	
	T save(T obj);
	
	void update(T obj);
	
	List<T> findAll();
	
	T findById(Long id);
	
	void delete(Long id);
	
	void delete(T obj);
}

