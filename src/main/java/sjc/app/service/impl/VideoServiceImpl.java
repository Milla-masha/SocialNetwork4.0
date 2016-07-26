package sjc.app.service.impl;

import org.springframework.stereotype.Service;
import sjc.app.model.vo.VideoFullVO;
import sjc.app.model.vo.VideoVO;
import sjc.app.service.VideoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Override
    public List<VideoVO> getVideos(Long userId, int offset, int limit) {
        List<VideoVO> videos = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            VideoVO video = new VideoVO();
            video.setName("Experiment");
            video.setPreView("https://klad.life/big/04CV2brhtr7cyGHd6HaUnNqQfqCEpZSagJeqiKdzfaXGaaPYqJZo1cd9qYfXnNBplumNSNpnqA1Jlkzah4a2ykj7bgug/yeksperiment-1.jpg");
            video.setUrl("https://cs510300.vk.me/0/u3331635/videos/7c22ac2fcb.480.mp4");
            videos.add(video);
        }
        return videos;
    }

    @Override
    public VideoFullVO getVideo(Long videoId) {
        VideoFullVO video = new VideoFullVO();
        video.setName("Experiment");
        video.setPreView("https://klad.life/big/04CV2brhtr7cyGHd6HaUnNqQfqCEpZSagJeqiKdzfaXGaaPYqJZo1cd9qYfXnNBplumNSNpnqA1Jlkzah4a2ykj7bgug/yeksperiment-1.jpg");
        video.setUrl("https://cs510300.vk.me/0/u3331635/videos/7c22ac2fcb.480.mp4");
        video.setDescription("dklrgje;sbg;kjasngkjdgkj;nadrkj;gnkjdrngkjnadk;rgnkjdn");
        return video;
    }
}
