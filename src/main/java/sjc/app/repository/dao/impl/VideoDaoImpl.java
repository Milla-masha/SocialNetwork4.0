package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.VideoEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.repository.dao.VideoDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class VideoDaoImpl  extends GenericDaoImpl<VideoEntityImpl> implements VideoDao {

    public VideoDaoImpl() {
        super(VideoEntityImpl.class);
    }

    @Override
    public List<VideoEntityImpl> getVideosUser(Long idUser, int offset, int limit) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<VideoEntityImpl> criteriaQuery = cb.createQuery(VideoEntityImpl.class);
        Root<VideoEntityImpl> root = criteriaQuery.from(VideoEntityImpl.class);
        Join<UserEntityImpl, VideoEntityImpl> usersJoin = root.join("users");
        criteriaQuery.select(usersJoin).where(cb.equal(usersJoin.get("id"), idUser));
        TypedQuery<VideoEntityImpl> q = getEntityManager().createQuery(criteriaQuery);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }
}
