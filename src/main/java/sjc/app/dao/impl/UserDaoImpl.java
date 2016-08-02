package sjc.app.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.dao.UserDao;
import sjc.app.model.entity.impl.UserEntityImpl;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class UserDaoImpl extends GenericDaoImpl<UserEntityImpl> implements UserDao {

    @Override
    public UserEntityImpl findById(Long id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<UserEntityImpl> c = cb.createQuery(UserEntityImpl.class);
        Root<UserEntityImpl> userEntityRoot = c.from(UserEntityImpl.class);
        Predicate condition = cb.equal(userEntityRoot.get("id"), id);
        c.where(condition);
        TypedQuery<UserEntityImpl> q = getEntityManager().createQuery(c);
        return q.getSingleResult();


//			return (RegisterUser) getEntityManager()
//				.createQuery("SELECT ru FROM RegisterUser ru where ru.login= ?").setParameter(0,userName).getResultList().get(0);
    }

    @Override
    public List<UserEntityImpl> getFriends(Long idUser, int offset, int limit) {

        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<UserEntityImpl> criteria = criteriaBuilder.createQuery(UserEntityImpl.class);

        Root<UserEntityImpl> entityRoot = criteria.from(UserEntityImpl.class);
        Predicate condition = criteriaBuilder.equal(entityRoot.get("id"), idUser);
        Join<UserEntityImpl, UserEntityImpl> joinAnswerCollaborator = entityRoot.join("friends");
        criteria.select(entityRoot);
        criteria.where(condition);

        TypedQuery<UserEntityImpl> q = getEntityManager().createQuery(criteria);

        q.setFirstResult(offset);
        q.setMaxResults(limit);

        return q.getResultList();
    }




}