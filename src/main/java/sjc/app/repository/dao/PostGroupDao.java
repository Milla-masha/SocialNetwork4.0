package sjc.app.repository.dao;

import sjc.app.model.entity.PostGroupEntityImpl;

import java.util.List;

public interface PostGroupDao extends GenericDao<PostGroupEntityImpl>
{
    List<PostGroupEntityImpl> getPostsGroup(Long idGroup, int offset, int limit);
}