package sjc.app.service;

import sjc.app.model.vo.PostSmallVO;
import sjc.app.model.vo.PostVO;

import java.util.List;

public interface PostService
{
    List<PostVO> getPosts(Long userId, int offset, int limit);

    boolean addPost(PostSmallVO post, String login);

    boolean deletePost(Long postId, String login);
}
