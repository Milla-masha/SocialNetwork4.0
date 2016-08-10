package sjc.app.service;

import sjc.app.model.vo.PostSmallVO;
import sjc.app.model.vo.PostVO;

import java.util.List;

public interface PostGroupService
{
    List<PostVO> getPostsGroup(Long idTo, int offset, int limit);

    boolean addPostGroup(PostSmallVO post, String login);

    boolean deletePostGroup(Long postId, String login);

    Long getCountPostsByGroup(Long groupId);
}
