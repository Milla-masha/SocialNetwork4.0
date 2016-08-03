package sjc.app.repository.dao;
import sjc.app.model.entity.UserEntityImpl;

public interface UserDao extends GenericDao<UserEntityImpl>{

	UserEntityImpl findByName(String userName);
}
