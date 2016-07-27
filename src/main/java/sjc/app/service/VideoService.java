package sjc.app.service;

import sjc.app.model.vo.VideoFullVO;
import sjc.app.model.vo.VideoVO;

import java.util.List;

public interface VideoService {
    List<VideoVO> getVideos(Long userId, int offset, int limit);
    VideoFullVO getVideo(Long videoId);
}
