package sjc.app.service;

import sjc.app.model.vo.VideoFullVO;

import java.util.List;

public interface VideoService
{
    List<VideoFullVO> getVideos(Long userId, int offset, int limit);

    VideoFullVO getVideo(Long videoId);
}
