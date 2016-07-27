package sjc.app.service;

import sjc.app.model.vo.MusicVO;

import java.util.List;

public interface MusicService
{
    List<MusicVO> getMusics(Long userId, int offset, int limit);
}
