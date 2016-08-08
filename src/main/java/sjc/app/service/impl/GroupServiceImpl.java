package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.GroupEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.vo.GroupSmallVO;
import sjc.app.model.vo.GroupVO;
import sjc.app.repository.dao.GroupDao;
import sjc.app.repository.dao.ImageDao;
import sjc.app.repository.dao.UserDao;
import sjc.app.service.GroupService;

import java.util.ArrayList;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class GroupServiceImpl implements GroupService
{

    @Autowired
    private GroupDao groupDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ImageDao imageDao;

    @Override
    public List<GroupVO> getGroups(Long userId, int offset, int limit)
    {
        List<GroupVO> groups = new ArrayList<>();
        List<GroupEntityImpl> groupsEnt = groupDao.getGroupsUser(userId, offset, limit);
        for (GroupEntityImpl groupEnt : groupsEnt)
        {
            GroupVO group = new GroupVO();
            group.setName(groupEnt.getName());
            group.setFolowers(groupEnt.getUsers().size());
            group.setImage(groupEnt.getImage().getUrl());
            groups.add(group);
        }
        return groups;
    }

    @Override
    public GroupVO getGroup(Long groupId)
    {

        GroupVO group = new GroupVO();
        GroupEntityImpl groupEntity = groupDao.findById(groupId);
        group.setName(groupEntity.getName());
        group.setFolowers(groupEntity.getUsers().size());
        group.setImage(groupEntity.getImage().getUrl());
        group.setDescription(groupEntity.getDescription());
        return group;
    }

    @Override
    public boolean addGroup(GroupSmallVO group, String login)
    {
        GroupEntityImpl groupEntity = new GroupEntityImpl();
        groupEntity.setName(group.getName());
        groupEntity.setDescription(group.getDescription());
        groupEntity.setOwner(userDao.findByName(login));
        groupEntity.setImage(imageDao.findById(group.getFkImage()));
        groupDao.save(groupEntity);
        return true;
    }

    @Override
    public boolean currentGroup(Long groupId, String login)
    {
        GroupEntityImpl groupEntity = groupDao.findById(groupId);
        UserEntityImpl userEntity = userDao.findByName(login);
        groupEntity.getUsers().add(userEntity);
        groupDao.update(groupEntity);
        return true;
    }

    @Override
    public boolean leaveGroup(Long groupId, String login)
    {
        GroupEntityImpl groupEntity = groupDao.findById(groupId);
        UserEntityImpl userEntity = userDao.findByName(login);
        groupEntity.getUsers().remove(userEntity);
        groupDao.update(groupEntity);
        return true;
    }
}
