package sjc.app.repository.dao;
import sjc.app.entity.RegisterUser;

public interface UserDao extends GenericDao<RegisterUser>{
	
	RegisterUser findByCredentials(String login, String password);

	RegisterUser findByName(String userName);
}
