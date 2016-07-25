package sjc.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjc.app.repository.dao.impl.InfoUserDaoImpl;
import sjc.app.repository.vo.ISmallUser;
import sjc.app.repository.vo.impl.SmallUserVO;
import sjc.app.service.FriendService;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendServiceImpl  implements FriendService
{

    @Autowired
    private InfoUserDaoImpl friendsDao;

    @Override
    public List<ISmallUser> getFriends(Long userId, int offset, int limit)
    {
        List<ISmallUser> friends= new ArrayList<>();
        for (int i=0;i<5;i++) {
            ISmallUser friend = new SmallUserVO();
            friend.setName("Denis");
            friend.setLastName("Andreenko");
            friend.setAvatar("https://pp.vk.me/c308320/v308320974/b07e/QLZ8yzHQuNQ.jpg");
            friends.add(friend);
        }
        return friends;
    }
}
