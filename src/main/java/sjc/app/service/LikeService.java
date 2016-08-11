package sjc.app.service;

import sjc.app.model.vo.LikeVO;

public interface LikeService
{
    boolean addLikeToPostUser(LikeVO likeVO, String login);

    boolean addLikeToPostGroup(LikeVO likeVO, String login);
}
