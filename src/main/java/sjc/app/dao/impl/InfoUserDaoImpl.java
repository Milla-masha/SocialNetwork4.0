package sjc.app.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.dao.InfoUserDao;
import sjc.app.model.entity.InfoUser;

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

        CriteriaQuery<InfoUser> criteria = criteriaBuilder.createQuery(InfoUser.class);

        Root<InfoUser> user = criteria.from(InfoUser.class);
        Predicate condition = criteriaBuilder.equal(user.get("user"), idUser);
        criteria.multiselect(user);
        criteria.where(condition);

        List<InfoUser> users = getEntityManager().createQuery( criteria ).getResultList();

       /* TypedQuery<InfoUser> q = getEntityManager().createQuery(criteria);

        q.setFirstResult(offset);
        q.setMaxResults(limit);*/
        return users; //q.getResultList();
    }
}
