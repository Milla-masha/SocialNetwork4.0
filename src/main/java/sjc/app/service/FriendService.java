package sjc.app.service;

import sjc.app.repository.vo.ISmallUser;
import sjc.app.repository.vo.impl.SmallUserVO;

import java.util.List;

public interface FriendService
{
    List<ISmallUser> getFriends(Long userId, int offset, int limit);
}
