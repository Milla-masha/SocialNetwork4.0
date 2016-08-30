package sjc.app.dao;


import sjc.app.model.entity.GroupEntityImpl;

import java.util.List;

public interface GroupDao extends GenericDao<GroupEntityImpl>
{
    List<GroupEntityImpl> getGroupsUser(Long idUser, int offset, int limit);

    Long getCountGroups(Long userId);

    List<GroupEntityImpl> findGroupsByName(String groupName, int offset, int limit);
}
