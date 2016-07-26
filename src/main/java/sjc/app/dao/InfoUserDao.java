package sjc.app.dao;

import sjc.app.model.entity.InfoUser;

import java.util.List;

public interface InfoUserDao extends GenericDao<InfoUser>
{
    List<InfoUser> getFriends(Long idUser, int offset, int limit);
}
