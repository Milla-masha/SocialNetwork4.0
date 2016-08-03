package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.MusicEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.repository.dao.MusicDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class MusicDaoImpl extends GenericDaoImpl<MusicEntityImpl> implements MusicDao {

    public MusicDaoImpl() {
        super(MusicEntityImpl.class);
    }

    @Override
    public List<MusicEntityImpl> getMusicsUser(Long idUser, int offset, int limit) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<MusicEntityImpl> criteriaQuery = cb.createQuery(MusicEntityImpl.class);
        Root<MusicEntityImpl> root = criteriaQuery.from(MusicEntityImpl.class);
        Join<UserEntityImpl, MusicEntityImpl> usersJoin = root.join("users");
        criteriaQuery.select(usersJoin).where(cb.equal(usersJoin.get("id"), idUser));
        TypedQuery<MusicEntityImpl> q = getEntityManager().createQuery(criteriaQuery);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }
}
