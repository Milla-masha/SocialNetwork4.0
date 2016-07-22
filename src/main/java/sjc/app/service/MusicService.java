package sjc.app.service;

import sjc.app.repository.vo.MusicVO;

import java.util.List;

public interface MusicService
{
    List<MusicVO> getMusics(Long userId);
}
