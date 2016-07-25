package sjc.app.service;

import sjc.app.model.vo.IVideo;
import sjc.app.model.vo.IVideoFull;

import java.util.List;

public interface VideoService {
    List<IVideo> getVideos(Long userId, int offset, int limit);
    IVideoFull getVideo(Long videoId);
}
