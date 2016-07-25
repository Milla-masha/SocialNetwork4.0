package sjc.app.service;

import sjc.app.model.vo.IGroup;

import java.util.List;

public interface GroupService
{
    List<IGroup> getGroups(Long userId, int offset, int limit);
    IGroup getGroup(Long groupId);
}
