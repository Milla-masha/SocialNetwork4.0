package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.entity.Music;
import sjc.app.repository.dao.MusicDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class MusicDaoImpl extends GenericDaoImpl<Music> implements MusicDao {
    @Override
    public List<Music> getMusicsUser(Long idUser) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Music> c = cb.createQuery(Music.class);
        Root<Music> music = c.from(Music.class);
        Predicate condition = cb.equal(music.get("user"), idUser);
        c.where(condition);
        TypedQuery<Music> q = getEntityManager().createQuery(c);
        return q.getResultList();

    }
}
