package sjc.app.service;

import sjc.app.model.vo.PostSmallVO;
import sjc.app.model.vo.PostVO;
import sjc.app.rest.exception.NoAccessExseption;
import sjc.app.rest.exception.NotFoundExseption;

import java.util.List;

public interface PostGroupService
{
    List<PostVO> getPostsGroup(String login, Long idTo, int offset, int limit);

    boolean addPostGroup(PostSmallVO post, String login) throws NotFoundExseption, NoAccessExseption;

    boolean deletePostGroup(Long postId, String login) throws NotFoundExseption, NoAccessExseption;

    Long getCountPostsByGroup(Long groupId);
}
