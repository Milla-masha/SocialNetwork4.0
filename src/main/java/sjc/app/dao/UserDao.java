package sjc.app.dao;


import sjc.app.model.entity.UserEntity;

public interface UserDao extends GenericDao<UserEntity> {

    //UserEntity findByCredentials(String login, String password);

   // UserEntity findByCredentials(String login, String password);

    UserEntity findByName(String userName);
}
