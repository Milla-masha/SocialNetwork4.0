package sjc.app.repository.dao;


import sjc.app.model.entity.VideoEntityImpl;

import java.util.List;

public interface VideoDao extends GenericDao<VideoEntityImpl>
{
    List<VideoEntityImpl> getVideosUser(Long idUser, int offset, int limit);

    VideoEntityImpl findVideoByUrl(String url);
}
