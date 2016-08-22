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
    public List<GroupVO> getGroups(Long userId, int offset, int limit, String login)
    {
        List<GroupVO> groups = new ArrayList<>();
        List<GroupEntityImpl> groupsEntities = groupDao.getGroupsUser(userId, offset, limit);
        for (GroupEntityImpl groupEntity : groupsEntities)
        {
            UserEntityImpl user = userDao.findByName(login);
            GroupVO group = new GroupVO();
            group.setId(groupEntity.getId());
            group.setName(groupEntity.getName());
            group.setFolowers(groupEntity.getUsers().size());
            group.setImage(groupEntity.getImage().getUrl());
            if (user.getGroups().contains(groupEntity))
            {
                group.setMember(true);
            } else
            {
                group.setMember(false);
            }
            if (groupEntity.getOwner().getId() == user.getId())
            {
                group.setOwner(true);
            } else
            {
                group.setOwner(false);
            }
            groups.add(group);
        }
        return groups;
    }

    @Override
    public Long getCountGroupsFromUser(Long userId)
    {
        return groupDao.getCountGroups(userId);
    }

    @Override
    public GroupVO getGroup(Long groupId, String login)
    {

        GroupVO group = new GroupVO();
        UserEntityImpl user = userDao.findByName(login);
        GroupEntityImpl groupEntity = groupDao.findById(groupId);
        group.setId(groupEntity.getId());
        group.setName(groupEntity.getName());
        group.setFolowers(groupEntity.getUsers().size());
        if (groupEntity.getImage() != null)
        {
            group.setImage(groupEntity.getImage().getUrl());
        }
        group.setDescription(groupEntity.getDescription());
        if (user.getGroups().contains(groupEntity))
        {
            group.setMember(true);
        } else
        {
            group.setMember(false);
        }
        if (groupEntity.getOwner().getId() == user.getId())
        {
            group.setOwner(true);
        } else
        {
            group.setOwner(false);
        }
        return group;
    }

    @Override
    public Long addGroup(GroupSmallVO group, String login)
    {
        GroupEntityImpl groupEntity = new GroupEntityImpl();
        groupEntity.setName(group.getName());
        groupEntity.setDescription(group.getDescription());
        UserEntityImpl user= userDao.findByName(login);
        groupEntity.setOwner(user);
        if (group.getUrlImage() != null)
        {
            groupEntity.setImage(imageDao.findImageByUrl(group.getUrlImage()));
        }
        else
        {
            groupEntity.setImage(imageDao.findById(65L));
        }
        groupEntity.getUsers().add(user);
        return groupDao.save(groupEntity).getId();
    }

    @Override
    public boolean addUserToGroup(Long groupId, String login)
    {
        GroupEntityImpl groupEntity = groupDao.findById(groupId);
        UserEntityImpl userEntity = userDao.findByName(login);
        if (groupEntity.getUsers().contains(userEntity))
        {
            return false;
        }
        groupEntity.getUsers().add(userEntity);
        groupDao.update(groupEntity);
        return true;
    }

    @Override
    public boolean leaveGroup(Long groupId, String login)
    {
        GroupEntityImpl groupEntity = groupDao.findById(groupId);
        UserEntityImpl userEntity = userDao.findByName(login);
        if (groupEntity.getUsers().contains(userEntity))
        {
            groupEntity.getUsers().remove(userEntity);
            groupDao.update(groupEntity);
            return true;
        } else return false;
    }

    @Override
    public List<GroupVO> findGroupsByName(String login ,String groupName, int offset, int limit)
    {
        List<GroupVO> groups = new ArrayList<>();
        List<GroupEntityImpl> groupsEntities = groupDao.findGroupsByName(groupName, offset, limit);
        for (GroupEntityImpl groupEntity : groupsEntities)
        {
            UserEntityImpl user = userDao.findByName(login);
            GroupVO group = new GroupVO();
            group.setId(groupEntity.getId());
            group.setName(groupEntity.getName());
            group.setFolowers(groupEntity.getUsers().size());
            group.setImage(groupEntity.getImage().getUrl());
            if (user.getGroups().contains(groupEntity))
            {
                group.setMember(true);
            } else
            {
                group.setMember(false);
            }
            if (groupEntity.getOwner().getId() == user.getId())
            {
                group.setOwner(true);
            } else
            {
                group.setOwner(false);
            }
            groups.add(group);
        }
        return groups;
    }

    @Override
    public boolean deleteGroup(Long groupId, String login)
    {
        GroupEntityImpl groupEntity=groupDao.findById(groupId);
        if(groupEntity.getOwner().getLogin().equals(login))
        {
            groupDao.delete(groupEntity);
            return true;
        }
        else
        {
         return false;
        }
    }
}
