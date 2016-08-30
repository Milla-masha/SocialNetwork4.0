package sjc.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.constant.Constant;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.dao.FriendDao;
import sjc.app.dao.UserDao;
import sjc.app.rest.exception.AlreadyExsistsException;
import sjc.app.rest.exception.NotFoundExseption;
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
    @Autowired
    private OnlineUser onlineUserService;

    @Override
    public List<UserSmallVO> getFriends(Long userId, int offset, int limit)
    {
        List<UserEntityImpl> infoFriend = friendsDao.getFriends(userId, offset, limit);
        List<UserSmallVO> friends = new ArrayList<>();
        for (UserEntityImpl user : infoFriend)
        {
            UserSmallVO friend = new UserSmallVO();
            friend.setOnline(onlineUserService.isOnline(user.getLogin()));
            friend.setId(user.getId());
            friend.setName(user.getName());
            friend.setLastName(user.getLastName());
            friend.setId(user.getId());
            if (user.getAvatar() != null)
            {
                friend.setAvatar(user.getAvatar().getUrl());
            }
            friends.add(friend);
        }
        return friends;
    }

    @Override
    public boolean addFriend(Long userId, String login) throws AlreadyExsistsException, NotFoundExseption
    {
        UserEntityImpl userEntity = userDao.findByName(login);
        UserEntityImpl friend = userDao.findById(userId);
        if (friend == null)
        {
            throw new NotFoundExseption("Friend " + userId + Constant.MESSAGE_NOT_FOUND);
        }
        if (userEntity.getFriends().contains(friend))
        {
            throw new AlreadyExsistsException("Friend " + userId + Constant.MESSAGE_EXIST);
        }
        userEntity.getFriends().add(friend);
        userDao.update(userEntity);
        return true;
    }

    @Override
    public boolean deleteFriend(Long userId, String login) throws NotFoundExseption
    {
        UserEntityImpl userEntity = userDao.findByName(login);
        UserEntityImpl friend = userDao.findById(userId);
        if (friend == null || !userEntity.getFriends().contains(friend))
        {
            throw new NotFoundExseption("Friend " + userId + Constant.MESSAGE_NOT_FOUND);
        }
        userEntity.getFriends().remove(friend);
        userDao.update(userEntity);
        return true;
    }

    @Override
    public Long getCountFriends(Long userId)
    {
        return friendsDao.getCountFriends(userId);
    }
}
