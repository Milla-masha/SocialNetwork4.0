package sjc.app.repository.dao;
import sjc.app.entity.RegisterUser;

public interface UserDao extends GenericDao<RegisterUser>{

	RegisterUser findByName(String userName);
}
