package sjc.app.service;

import sjc.app.model.vo.PostSmallVO;
import sjc.app.model.vo.PostVO;

import java.util.List;

public interface PostUserService
{
    List<PostVO> getPostsUser(Long idTo, int offset, int limit);

    boolean addPostUser(PostSmallVO post, String login);

    boolean deletePostUser(Long postId, String login);
}
