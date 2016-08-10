package sjc.app.repository.dao;

import sjc.app.model.entity.PostUserEntityImpl;

import java.util.List;

public interface PostUserDao extends GenericDao<PostUserEntityImpl>
{
    List<PostUserEntityImpl> getPostsUser(Long idUser, int offset, int limit);

    Long getCountPostsUser(Long idUser);
}
