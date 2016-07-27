package sjc.app.repository.dao;
import sjc.app.model.entity.UserEntity;

public interface UserDao extends GenericDao<UserEntity>{

	UserEntity findByName(String userName);
}
