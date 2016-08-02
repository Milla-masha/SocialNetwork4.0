package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjc.app.dao.MusicDao;
import sjc.app.model.entity.impl.MusicEntityImpl;
import sjc.app.model.vo.MusicVO;
import sjc.app.service.MusicService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicDao musicDao;

    @Override
    public List<MusicVO> getMusics(Long userId, int offset, int limit) {
        List<MusicEntityImpl> musics = musicDao.getMusicsUser(userId, offset, limit);
        List<MusicVO> musicVOs = new ArrayList<>();
        for (MusicEntityImpl music : musics) {
            MusicVO mus = new MusicVO();
            mus.setUrl(music.getUrl());
            mus.setName(music.getName());
            mus.setTime(music.getTime());
            musicVOs.add(mus);
        }
        return musicVOs;
    }
}
