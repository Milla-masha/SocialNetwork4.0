package sjc.app.service;

import sjc.app.model.vo.PostSmallVO;
import sjc.app.model.vo.PostVO;
import sjc.app.rest.exception.NoAccessExseption;
import sjc.app.rest.exception.NotFoundExseption;

import java.util.List;

public interface PostUserService
{
    List<PostVO> getPostsUser(String login,Long idTo, int offset, int limit);

    boolean addPostUser(PostSmallVO post, String login) throws NoAccessExseption, NotFoundExseption;

    boolean deletePostUser(Long postId, String login) throws NotFoundExseption, NoAccessExseption;

    Long getCountPostsUser(Long idUser);
}
