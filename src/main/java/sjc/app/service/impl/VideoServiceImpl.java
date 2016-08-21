package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.entity.VideoEntityImpl;
import sjc.app.model.vo.VideoFullVO;
import sjc.app.repository.dao.UserDao;
import sjc.app.repository.dao.VideoDao;
import sjc.app.service.VideoService;

import java.util.ArrayList;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class VideoServiceImpl implements VideoService
{

    @Autowired
    private VideoDao videoDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<VideoFullVO> getVideos(Long userId, int offset, int limit)
    {
        List<VideoEntityImpl> videosEntity = videoDao.getVideosUser(userId, offset, limit);
        List<VideoFullVO> videos = new ArrayList<>();
        for (VideoEntityImpl videoEntity : videosEntity)
        {
            VideoFullVO video = new VideoFullVO();
            video.setId(videoEntity.getId());
            video.setName(videoEntity.getName());
            video.setPreView(videoEntity.getPreview());
            video.setUrl(videoEntity.getUrl());
            videos.add(video);
        }
        return videos;
    }

    @Override
    public Long getCountVideosUser(Long userId)
    {
        return videoDao.getCountVideosUser(userId);
    }

    @Override
    public VideoFullVO getVideo(Long videoId)
    {
        VideoEntityImpl videoEntity = videoDao.findById(videoId);
        VideoFullVO video = new VideoFullVO();
        video.setId(videoEntity.getId());
        video.setName(videoEntity.getName());
        video.setPreView(videoEntity.getPreview());
        video.setUrl(videoEntity.getUrl());
        return video;
    }

    @Override
    public boolean addVideoToUser(String url, String login)
    {
        UserEntityImpl user = userDao.findByName(login);
        VideoEntityImpl videoEntity = videoDao.findVideoByUrl(url);
        if (user.getVideos().contains(videoEntity))
        {
            return false;
        } else user.getVideos().add(videoEntity);
        userDao.update(user);
        return true;
    }

    @Override
    public boolean deleteVideoToUser(Long id, String login)
    {
        UserEntityImpl user = userDao.findByName(login);
        VideoEntityImpl videoEntity = videoDao.findById(id);
        if (user.getVideos().contains(videoEntity))
        {
            user.getVideos().remove(videoEntity);
            userDao.update(user);
            return true;
        } else
        {
            return false;
        }
    }
}
