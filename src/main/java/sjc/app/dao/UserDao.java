package sjc.app.dao;

import sjc.app.model.entity.UserEntityImpl;

import java.util.List;

public interface UserDao extends GenericDao<UserEntityImpl>
{

    UserEntityImpl findByName(String userName);

    UserEntityImpl findByEmail(String email);

    List<UserEntityImpl> findByFullName(String fullName, int offset, int limit);

    List<UserEntityImpl> getUsers(int offset, int limit);

    Boolean isExistLoginFromUser(String login);

    Boolean isExistEmailFromUser(String email);

}
