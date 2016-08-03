package sjc.app.repository.dao;


import sjc.app.model.entity.GroupEntityImpl;

import java.util.List;

public interface GroupDao extends GenericDao<GroupEntityImpl>
{
    List<GroupEntityImpl> getGroupsUser(Long idUser, int offset, int limit);
}
