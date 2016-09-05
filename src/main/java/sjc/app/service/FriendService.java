package sjc.app.service;


import sjc.app.model.vo.FriendVO;
import sjc.app.rest.exception.AlreadyExsistsException;
import sjc.app.rest.exception.NotFoundExseption;

import java.util.List;

public interface FriendService
{
    List<FriendVO> getFriends(String login,Long userId, int offset, int limit);

    boolean addFriend(Long userId, String login) throws AlreadyExsistsException, NotFoundExseption;

    boolean deleteFriend(Long userId, String login) throws NotFoundExseption;

    Long getCountFriends(Long userId);

}
