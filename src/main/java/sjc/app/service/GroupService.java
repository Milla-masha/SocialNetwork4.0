package sjc.app.service;

import sjc.app.model.vo.GroupSmallVO;
import sjc.app.model.vo.GroupVO;
import sjc.app.rest.exception.AlreadyExsistsException;
import sjc.app.rest.exception.NoAccessExseption;
import sjc.app.rest.exception.NotFoundExseption;

import java.util.List;

public interface GroupService
{
    List<GroupVO> getGroups(Long userId, int offset, int limit, String login);

    Long getCountGroupsFromUser(Long userId);

    GroupVO getGroup(Long groupId, String login);

    Long addGroup(GroupSmallVO group, String login);

    boolean addUserToGroup(Long groupId, String login) throws NotFoundExseption, AlreadyExsistsException;

    boolean leaveGroup(Long groupId, String login) throws NotFoundExseption;

    List<GroupVO> findGroupsByName(String login, String groupName, int offset, int limit);

    boolean deleteGroup(Long groupId, String login) throws NotFoundExseption, NoAccessExseption;
}
