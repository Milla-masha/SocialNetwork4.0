package sjc.app.service;

import sjc.app.model.vo.IMusic;

import java.util.List;

public interface MusicService
{
    List<IMusic> getMusics(Long userId, int offset, int limit);
}
