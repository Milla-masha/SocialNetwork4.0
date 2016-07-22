package sjc.app.repository.dao;

import sjc.app.entity.UserEntity;

public interface UserDao extends GenericDao<UserEntity> {

    UserEntity findByCredentials(String login, String password);

    UserEntity findByName(String userName);
}
