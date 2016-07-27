package sjc.app.repository.dao;


import sjc.app.model.entity.Group;

import java.util.List;

public interface GroupDao extends GenericDao<Group>
{
    List<Group> getGroupsUser(Long idUser, int offset, int limit);
}
