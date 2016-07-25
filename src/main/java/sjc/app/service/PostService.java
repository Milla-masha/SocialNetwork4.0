package sjc.app.service;

import sjc.app.repository.vo.IPost;

import java.util.List;

public interface PostService
{
    List<IPost> getPosts(Long userId, int offset, int limit);
}
