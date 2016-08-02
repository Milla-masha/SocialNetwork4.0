package sjc.app.dao;


import sjc.app.model.entity.impl.UserEntityImpl;

import java.util.Collection;

public interface UserDao extends GenericDao<UserEntityImpl> {

    UserEntityImpl findById(Long id);

    Collection<UserEntityImpl> getFriends(Long idUser, int offset, int limit);
}
