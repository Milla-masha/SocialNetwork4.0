package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjc.app.model.entity.Music;
import sjc.app.repository.dao.MusicDao;
import sjc.app.model.vo.IMusic;
import sjc.app.model.vo.impl.MusicVO;
import sjc.app.service.MusicService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService
{
    @Autowired
    private MusicDao musicDao;

    @Override
    public List<IMusic> getMusics(Long userId, int offset, int limit)
    {
        List<Music> musics=musicDao.getMusicsUser(userId,offset,limit);
        List<IMusic> musicVOs=new ArrayList<>();
        for (Music music:musics)
        {
         IMusic mus=new MusicVO();
            mus.setUrl(music.getUrl());
            mus.setName(music.getName());
            mus.setTime(music.getTime());
            musicVOs.add(mus);
        }
        return musicVOs;
    }
}
