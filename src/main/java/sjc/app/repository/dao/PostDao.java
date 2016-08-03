package sjc.app.repository.dao;

import sjc.app.model.entity.PostEntityImpl;
import sjc.app.model.entity.PostUserEntityImpl;

import java.util.List;

public interface PostDao extends GenericDao<PostEntityImpl>
{
    List<PostUserEntityImpl> getPostsUser(Long idUser, int offset, int limit);
}
