package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.InfoUser;
import sjc.app.repository.dao.InfoUserDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class InfoUserDaoImpl extends GenericDaoImpl<InfoUser> implements InfoUserDao
{
    @Override
    public List<InfoUser> getFriends(Long idUser, int offset, int limit) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<InfoUser> c = cb.createQuery(InfoUser.class);
        Root<InfoUser> users = c.from(InfoUser.class);
        Predicate condition = cb.equal(users.get("user"), idUser);
        c.where(condition);
        TypedQuery<InfoUser> q = getEntityManager().createQuery(c);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }
}
