package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.MusicEntityImpl;
import sjc.app.model.vo.MusicVO;
import sjc.app.repository.dao.MusicDao;
import sjc.app.service.MusicService;

import java.util.ArrayList;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class MusicServiceImpl implements MusicService
{
    @Autowired
    private MusicDao musicDao;

    @Override
    public List<MusicVO> getMusics(Long userId, int offset, int limit)
    {
        List<MusicEntityImpl> musics = musicDao.getMusicsUser(userId, offset, limit);
        List<MusicVO> musicVOs = new ArrayList<>();
        for (MusicEntityImpl music : musics)
        {
            MusicVO mus = new MusicVO();
            mus.setUrl(music.getUrl());
            mus.setName(music.getName());
            musicVOs.add(mus);
        }
        return musicVOs;
    }
}
