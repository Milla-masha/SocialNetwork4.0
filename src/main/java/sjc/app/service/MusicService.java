package sjc.app.service;

import sjc.app.model.vo.MusicVO;
import sjc.app.rest.exception.AlreadyExsistsException;
import sjc.app.rest.exception.NotFoundExseption;

import java.util.List;

public interface MusicService
{
    List<MusicVO> getMusics(Long userId, int offset, int limit);

    Long getCountMusicsUser(Long userId);

    boolean addMusicToUser(String url, String login) throws NotFoundExseption, AlreadyExsistsException;

    boolean deleteMusicToUser(Long id, String login) throws NotFoundExseption;
}
