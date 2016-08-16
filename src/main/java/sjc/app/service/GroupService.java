package sjc.app.service;

import sjc.app.model.vo.GroupSmallVO;
import sjc.app.model.vo.GroupVO;

import java.util.List;

public interface GroupService
{
    List<GroupVO> getGroups(Long userId, int offset, int limit);

    GroupVO getGroup(Long groupId);

    boolean addGroup(GroupSmallVO group, String login);

    boolean addUserToGroup(Long groupId, String login);

    boolean leaveGroup(Long groupId, String login);
}
