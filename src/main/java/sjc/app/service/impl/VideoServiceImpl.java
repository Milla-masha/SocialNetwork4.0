package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.VideoEntityImpl;
import sjc.app.model.vo.VideoFullVO;
import sjc.app.repository.dao.VideoDao;
import sjc.app.service.VideoService;

import java.util.ArrayList;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    @Override
    public List<VideoFullVO> getVideos(Long userId, int offset, int limit) {
        List<VideoEntityImpl> videosEntity=videoDao.getVideosUser(userId,offset,limit);
        List<VideoFullVO> videos = new ArrayList<>();
        for (VideoEntityImpl videoEntity:videosEntity) {
            VideoFullVO video = new VideoFullVO();
            video.setName(videoEntity.getName());
            video.setPreView(videoEntity.getPreview());
            video.setUrl(videoEntity.getUrl());
            videos.add(video);
        }
        return videos;
    }

    @Override
    public VideoFullVO getVideo(Long videoId) {
        VideoEntityImpl videoEntity=videoDao.findById(videoId);
        VideoFullVO video = new VideoFullVO();
        video.setName(videoEntity.getName());
        video.setPreView(videoEntity.getPreview());
        video.setUrl(videoEntity.getUrl());
      //  video.setDescription(videoEntity.);
        return video;
    }
}
