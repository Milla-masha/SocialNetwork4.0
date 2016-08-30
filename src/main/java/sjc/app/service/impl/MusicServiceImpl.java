package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.constant.Constant;
import sjc.app.model.entity.MusicEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.vo.MusicVO;
import sjc.app.dao.MusicDao;
import sjc.app.dao.UserDao;
import sjc.app.rest.exception.AlreadyExsistsException;
import sjc.app.rest.exception.NotFoundExseption;
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
    @Autowired
    private UserDao userDao;

    @Override
    public List<MusicVO> getMusics(Long userId, int offset, int limit)
    {
        List<MusicEntityImpl> musicEntities = musicDao.getMusicsUser(userId, offset, limit);
        List<MusicVO> musicVOs = new ArrayList<>();
        for (MusicEntityImpl music : musicEntities)
        {
            MusicVO musicVO = new MusicVO();
            musicVO.setId(music.getId());
            musicVO.setUrl(music.getUrl());
            musicVO.setName(music.getName());
            musicVOs.add(musicVO);
        }
        return musicVOs;
    }

    @Override
    public Long getCountMusicsUser(Long userId)
    {
        return musicDao.getCountMusicsUser(userId);
    }

    @Override
    public boolean addMusicToUser(String url, String login) throws NotFoundExseption, AlreadyExsistsException
    {
        UserEntityImpl user = userDao.findByName(login);
        MusicEntityImpl musicEntity = musicDao.findMusicByUrl(url);
        if (musicEntity == null)
        {
            throw new NotFoundExseption(Constant.MUSIC_URL + url + Constant.MESSAGE_NOT_FOUND);
        }
        if (user.getMusics().contains(musicEntity))
        {
            throw new AlreadyExsistsException(Constant.MUSIC_URL+url+Constant.MESSAGE_EXIST);
        } else user.getMusics().add(musicEntity);
        userDao.update(user);
        return true;
    }

    @Override
    public boolean deleteMusicToUser(Long id, String login) throws NotFoundExseption
    {
        UserEntityImpl user = userDao.findByName(login);
        MusicEntityImpl musicEntity = musicDao.findById(id);
        if (musicEntity == null)
        {
            throw new NotFoundExseption(Constant.MUSIC_ID + id + Constant.MESSAGE_NOT_FOUND);
        }
        if (user.getMusics().contains(musicEntity))
        {
            user.getMusics().remove(musicEntity);
            userDao.update(user);
            return true;
        } else
        {
            throw new NotFoundExseption(Constant.MUSIC_ID + id + Constant.MESSAGE_NOT_FOUND_USER+login);
        }
    }
}
