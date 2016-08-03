package sjc.app.repository.dao;

import sjc.app.model.entity.UserEntityImpl;

import java.util.List;

public interface FriendDao
{
    List<UserEntityImpl> getFriends(Long idUser, int offset, int limit);
}
