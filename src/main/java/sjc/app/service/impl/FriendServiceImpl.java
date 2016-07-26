package sjc.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjc.app.model.entity.InfoUser;
import sjc.app.dao.impl.InfoUserDaoImpl;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.service.FriendService;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendServiceImpl  implements FriendService
{

    @Autowired
    private InfoUserDaoImpl friendsDao;

    @Override
    public List<UserSmallVO> getFriends(Long userId, int offset, int limit)
    {
        List<InfoUser> infoFriend=friendsDao.getFriends(userId,offset,limit);
        List<UserSmallVO> friends= new ArrayList<>();
        for (InfoUser user:infoFriend)
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
