package sjc.app.dao;

import sjc.app.model.entity.MusicEntityImpl;

import java.util.List;

public interface MusicDao extends GenericDao<MusicEntityImpl>
{
    List<MusicEntityImpl> getMusicsUser(Long idUser, int offset, int limit);

    Long getCountMusicsUser(Long id);

    MusicEntityImpl findMusicByUrl(String url);
}
