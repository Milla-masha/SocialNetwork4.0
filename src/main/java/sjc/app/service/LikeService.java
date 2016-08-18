package sjc.app.service;

import sjc.app.model.vo.LikeVO;

public interface LikeService
{
    Integer addLikeToPostUser(LikeVO likeVO, Long idPost, String login);

    Integer addLikeToPostGroup(LikeVO likeVO, Long idPost, String login);
}
