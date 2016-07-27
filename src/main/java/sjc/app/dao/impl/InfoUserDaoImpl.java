package sjc.app.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.dao.InfoUserDao;
import sjc.app.model.entity.InfoUser;

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
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<InfoUser> criteriaQuery = criteriaBuilder.createQuery(InfoUser.class);
        Root<InfoUser> users = criteriaQuery.from(InfoUser.class);


        Predicate condition = criteriaBuilder.equal(users.get("user"), idUser);
        criteriaQuery.where(condition);
        TypedQuery<InfoUser> q = getEntityManager().createQuery(criteriaQuery);
        q.setFirstResult(offset);
        q.setMaxResults(limit);



        return q.getResultList();
    }
}