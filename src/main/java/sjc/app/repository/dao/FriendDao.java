package sjc.app.repository.dao;

import sjc.app.model.entity.InfoUser;

import java.util.List;

public interface FriendDao
{
    List<InfoUser> getFriends(Long idUser, int offset, int limit);
}
