package sjc.app.repository.dao;
import sjc.app.model.entity.RegisterUser;

public interface UserDao extends GenericDao<RegisterUser>{

	RegisterUser findByName(String userName);
}
