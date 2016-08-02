package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.Music;
import sjc.app.model.entity.Video;
import sjc.app.repository.dao.VideoDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class VideoDaoImpl  extends GenericDaoImpl<Video> implements VideoDao {

    public VideoDaoImpl() {
        super(Video.class);
    }

    @Override
    public List<Video> getVideosUser(Long idUser, int offset, int limit) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Video> c = cb.createQuery(Video.class);
        Root<Video> video = c.from(Video.class);
        Predicate condition = cb.equal(video.get("fkUser"), idUser);
        c.where(condition);
        TypedQuery<Video> q = getEntityManager().createQuery(c);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }
}
