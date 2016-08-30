package sjc.app.dao;

import sjc.app.model.entity.UserEntityImpl;

import java.util.List;

public interface FriendDao extends GenericDao<UserEntityImpl>
{
    List<UserEntityImpl> getFriends(Long userId, int offset, int limit);

    Long getCountFriends(Long userId);
}
