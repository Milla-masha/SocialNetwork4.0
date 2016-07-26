package sjc.app.service;

import sjc.app.model.vo.GroupVO;

import java.util.List;

public interface GroupService
{
    List<GroupVO> getGroups(Long userId, int offset, int limit);
    GroupVO getGroup(Long groupId);
}
