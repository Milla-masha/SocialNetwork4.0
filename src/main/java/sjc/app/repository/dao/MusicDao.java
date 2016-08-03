package sjc.app.repository.dao;

import sjc.app.model.entity.MusicEntityImpl;

import java.util.List;

public interface MusicDao extends GenericDao<MusicEntityImpl>
{
    List<MusicEntityImpl> getMusicsUser(Long idUser, int offset, int limit);
}
