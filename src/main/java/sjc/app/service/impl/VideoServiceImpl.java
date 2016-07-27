package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.Video;
import sjc.app.model.vo.VideoFullVO;
import sjc.app.model.vo.VideoVO;
import sjc.app.repository.dao.MusicDao;
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
    public List<VideoVO> getVideos(Long userId, int offset, int limit) {
        List<Video> videosEntity=videoDao.getVideosUser(userId,offset,limit);
        List<VideoVO> videos = new ArrayList<>();
        for (Video videoEntity:videosEntity) {
            VideoVO video = new VideoVO();
            video.setName(videoEntity.getName());
            video.setPreView(videoEntity.getPreview());
            video.setUrl(videoEntity.getUrl());
            videos.add(video);
        }
        return videos;
    }

    @Override
    public VideoFullVO getVideo(Long videoId) {
        Video videoEntity=videoDao.findById(videoId);
        VideoFullVO video = new VideoFullVO();
        video.setName(videoEntity.getName());
        video.setPreView(videoEntity.getPreview());
        video.setUrl(videoEntity.getUrl());
      //  video.setDescription(videoEntity.);
        return video;
    }
}
