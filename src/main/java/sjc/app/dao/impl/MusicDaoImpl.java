package sjc.app.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.dao.MusicDao;
import sjc.app.model.entity.MusicEntityImpl;
import sjc.app.model.entity.UserEntityImpl;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class MusicDaoImpl extends GenericDaoImpl<MusicEntityImpl> implements MusicDao
{

    public MusicDaoImpl()
    {
        super(MusicEntityImpl.class);
    }

    @Override
    public List<MusicEntityImpl> getMusicsUser(Long idUser, int offset, int limit)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<MusicEntityImpl> criteriaQuery = cb.createQuery(MusicEntityImpl.class);
        Root<MusicEntityImpl> root = criteriaQuery.from(MusicEntityImpl.class);
        Join<UserEntityImpl, MusicEntityImpl> usersJoin = root.join("users");
        criteriaQuery.select(root).where(cb.equal(usersJoin.get("id"), idUser));
        TypedQuery<MusicEntityImpl> q = getEntityManager().createQuery(criteriaQuery);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public Long getCountMusicsUser(Long idUser)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<MusicEntityImpl> root = cq.from(MusicEntityImpl.class);
        Join<UserEntityImpl, MusicEntityImpl> usersJoin = root.join("users");
        cq.select(cb.count(root)).where(cb.equal(usersJoin.get("id"), idUser));
        return getEntityManager().createQuery(cq).getSingleResult();
    }

    @Override
    public MusicEntityImpl findMusicByUrl(String url)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<MusicEntityImpl> c = cb.createQuery(MusicEntityImpl.class);
        Root<MusicEntityImpl> musicEntityRoot = c.from(MusicEntityImpl.class);
        Predicate condition = cb.equal(musicEntityRoot.get("url"), url);
        c.where(condition);
        TypedQuery<MusicEntityImpl> q = getEntityManager().createQuery(c);
        return q.getResultList().get(0);
    }
}
