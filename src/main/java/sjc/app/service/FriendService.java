package sjc.app.service;

import sjc.app.model.vo.IUserSmall;


import java.util.List;

public interface FriendService
{
    List<IUserSmall> getFriends(Long userId, int offset, int limit);
}
