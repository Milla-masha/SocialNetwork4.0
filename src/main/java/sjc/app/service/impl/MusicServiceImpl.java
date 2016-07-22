package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjc.app.entity.Music;
import sjc.app.repository.dao.MusicDao;
import sjc.app.repository.vo.MusicVO;
import sjc.app.service.MusicService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService
{
    @Autowired
    private MusicDao musicDao;

    @Override
    public List<MusicVO> getMusics(Long userId)
    {
        List<Music> musics=musicDao.getMusicsUser(userId);
        List<MusicVO> musicVOs=new ArrayList<MusicVO>();
        for (Music music:musics)
        {
         MusicVO mus=new MusicVO(music.getUrl(),music.getName(),music.getTime());
            musicVOs.add(mus);
        }
        return musicVOs;
    }
}
