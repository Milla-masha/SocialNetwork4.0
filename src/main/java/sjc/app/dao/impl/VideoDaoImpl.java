package sjc.app.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.entity.VideoEntityImpl;
import sjc.app.dao.VideoDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class VideoDaoImpl extends GenericDaoImpl<VideoEntityImpl> implements VideoDao
{

    public VideoDaoImpl()
    {
        super(VideoEntityImpl.class);
    }

    @Override
    public List<VideoEntityImpl> getVideosUser(Long idUser, int offset, int limit)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<VideoEntityImpl> criteriaQuery = cb.createQuery(VideoEntityImpl.class);
        Root<VideoEntityImpl> root = criteriaQuery.from(VideoEntityImpl.class);
        Join<UserEntityImpl, VideoEntityImpl> usersJoin = root.join("users");
        criteriaQuery.select(root).where(cb.equal(usersJoin.get("id"), idUser));
        TypedQuery<VideoEntityImpl> q = getEntityManager().createQuery(criteriaQuery);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public Long getCountVideosUser(Long idUser)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<VideoEntityImpl> root = cq.from(VideoEntityImpl.class);
        Join<UserEntityImpl, VideoEntityImpl> usersJoin = root.join("users");
        cq.select(cb.count(root)).where(cb.equal(usersJoin.get("id"), idUser));
        return getEntityManager().createQuery(cq).getSingleResult();
    }

    @Override
    public VideoEntityImpl findVideoByUrl(String url)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<VideoEntityImpl> c = cb.createQuery(VideoEntityImpl.class);
        Root<VideoEntityImpl> videoEntityRoot = c.from(VideoEntityImpl.class);
        Predicate condition = cb.equal(videoEntityRoot.get("url"), url);
        c.where(condition);
        TypedQuery<VideoEntityImpl> q = getEntityManager().createQuery(c);
        return q.getResultList().get(0);
    }
}
