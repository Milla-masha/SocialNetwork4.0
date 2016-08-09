package sjc.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.repository.dao.FriendDao;
import sjc.app.repository.dao.UserDao;
import sjc.app.service.FriendService;

import java.util.ArrayList;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class FriendServiceImpl implements FriendService
{

    @Autowired
    private FriendDao friendsDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserSmallVO> getFriends(Long userId, int offset, int limit)
    {
        List<UserEntityImpl> infoFriend = friendsDao.getFriends(userId, offset, limit);
        List<UserSmallVO> friends = new ArrayList<>();
        for (UserEntityImpl user : infoFriend)
        {
            UserSmallVO friend = new UserSmallVO();
            friend.setName(user.getName());
            friend.setLastName(user.getLastName());
            friend.setIdUser(user.getId());
            if(user.getAvatar()!=null)
            {
                friend.setAvatar(user.getAvatar().getUrl());
            }
            friends.add(friend);
        }
        return friends;
    }

    @Override
    public boolean addFriend(Long userId, String login)
    {
        try
        {
            UserEntityImpl userEntity = userDao.findByName(login);
            UserEntityImpl friend = userDao.findById(userId);
            userEntity.getFriends().add(friend);
            userDao.update(userEntity);
            return true;
        }
        catch (NullPointerException ne)
        {
            return false;
        }
    }

    @Override
    public boolean deleteFriend(Long userId, String login)
    {
        UserEntityImpl userEntity = userDao.findByName(login);
        UserEntityImpl friend = userDao.findById(userId);
        userEntity.getFriends().remove(friend);
        userDao.update(userEntity);
        return true;
    }
}
