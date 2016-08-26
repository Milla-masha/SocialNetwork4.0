package sjc.app.service;

import sjc.app.model.vo.VideoFullVO;
import sjc.app.rest.exception.AlreadyExsistsException;
import sjc.app.rest.exception.NotFoundExseption;

import java.util.List;

public interface VideoService
{
    List<VideoFullVO> getVideos(Long userId, int offset, int limit);

    Long getCountVideosUser(Long userId);

    VideoFullVO getVideo(Long videoId) throws NotFoundExseption;

    boolean addVideoToUser(String url, String login) throws NotFoundExseption, AlreadyExsistsException;

    boolean deleteVideoToUser(Long id, String login) throws NotFoundExseption;
}
