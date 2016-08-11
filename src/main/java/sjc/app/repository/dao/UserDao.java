package sjc.app.repository.dao;

import sjc.app.model.entity.UserEntityImpl;

import java.util.List;

public interface UserDao extends GenericDao<UserEntityImpl>{

	UserEntityImpl findByName(String userName);

	List<UserEntityImpl> findByFullName(String fullName, int offset, int limit);

	List<UserEntityImpl> getUsers(int offset, int limit);
}
