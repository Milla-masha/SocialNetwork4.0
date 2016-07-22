package sjc.app.repository.dao;

import sjc.app.entity.Music;

import java.util.List;

public interface MusicDao extends GenericDao<Music>
{
    List<Music> getMusicsUser(Long idUser);
}
