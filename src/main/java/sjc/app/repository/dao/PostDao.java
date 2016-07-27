package sjc.app.repository.dao;

import sjc.app.model.entity.Post;

import java.util.List;

public interface PostDao extends GenericDao<Post>
{
    List<Post> getPostsUser(Long idUser, int offset, int limit);
}
