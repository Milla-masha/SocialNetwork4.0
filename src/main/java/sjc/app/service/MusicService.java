package sjc.app.service;

import sjc.app.repository.vo.IMusic;
import sjc.app.repository.vo.impl.MusicVO;

import java.util.List;

public interface MusicService
{
    List<IMusic> getMusics(Long userId);
}
