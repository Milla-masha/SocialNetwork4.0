package sjc.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.repository.dao.FriendDao;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.service.FriendService;

import java.util.ArrayList;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class FriendServiceImpl  implements FriendService
{

    @Autowired
    private FriendDao friendsDao;

    @Override
    public List<UserSmallVO> getFriends(Long userId, int offset, int limit)
    {
        List<UserEntityImpl> infoFriend=friendsDao.getFriends(userId,offset,limit);
        List<UserSmallVO> friends= new ArrayList<>();
        for (UserEntityImpl user:infoFriend)
        {
            UserSmallVO friend = new UserSmallVO();
            friend.setName(user.getName());
            friend.setLastName(user.getLastName());
            friend.setAvatar(user.getAvatar());
            friends.add(friend);
        }
        return friends;
    }
}
