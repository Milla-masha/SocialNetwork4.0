package sjc.app.dao;


import sjc.app.model.entity.VideoEntityImpl;

import java.util.List;

public interface VideoDao extends GenericDao<VideoEntityImpl>
{
    List<VideoEntityImpl> getVideosUser(Long idUser, int offset, int limit);

    Long getCountVideosUser(Long id);

    VideoEntityImpl findVideoByUrl(String url);
}