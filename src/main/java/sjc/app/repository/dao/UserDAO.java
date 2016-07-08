package sjc.app.repository.dao;
import sjc.app.repository.base.*;
import sjc.app.repository.entity.User;

public interface UserDAO extends GenericDao<User>{
	
	User findByCredentials(String login, String password);

	User findByName(String userName);
}
