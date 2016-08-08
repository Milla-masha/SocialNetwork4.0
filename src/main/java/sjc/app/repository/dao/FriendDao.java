package sjc.app.repository.dao;

import sjc.app.model.entity.UserEntityImpl;

import java.util.List;

public interface FriendDao extends GenericDao<UserEntityImpl>
{
    List<UserEntityImpl> getFriends(Long idUser, int offset, int limit);
}
