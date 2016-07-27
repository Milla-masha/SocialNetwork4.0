package sjc.app.repository.dao;


import sjc.app.model.entity.Video;

import java.util.List;

public interface VideoDao extends GenericDao<Video>
{
    List<Video> getVideosUser(Long idUser, int offset, int limit);
}
