package sjc.app.service;


import sjc.app.model.vo.UserSmallVO;

import java.util.List;

public interface FriendService
{
    List<UserSmallVO> getFriends(Long userId, int offset, int limit);

    boolean addFriend(Long userId, String login);

    boolean deleteFriend(Long userId, String login);

    List<UserSmallVO> findFriends(String name, Long userId, int offset, int limit);

    Long getCountFriends(Long userId);
}
