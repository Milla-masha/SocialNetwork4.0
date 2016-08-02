package sjc.app.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.impl.MusicEntityImpl;
import sjc.app.dao.MusicDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class MusicDaoImpl extends GenericDaoImpl<MusicEntityImpl> implements MusicDao {
    @Override
    public List<MusicEntityImpl> getMusicsUser(Long idUser, int offset, int limit) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<MusicEntityImpl> c = cb.createQuery(MusicEntityImpl.class);
        Root<MusicEntityImpl> music = c.from(MusicEntityImpl.class);
        Predicate condition = cb.equal(music.get("user"), idUser);
        c.where(condition);
        TypedQuery<MusicEntityImpl> q = getEntityManager().createQuery(c);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }
}
