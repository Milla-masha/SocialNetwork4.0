package sjc.app.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.dao.UserDao;
import sjc.app.model.entity.UserEntity;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class UserDaoImpl extends GenericDaoImpl<UserEntity> implements UserDao {

    @Override
    public UserEntity findByName(String userName) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<UserEntity> c = cb.createQuery(UserEntity.class);
        Root<UserEntity> userEntityRoot = c.from(UserEntity.class);
        Predicate condition = cb.equal(userEntityRoot.get("login"), userName);
        c.where(condition);
        TypedQuery<UserEntity> q = getEntityManager().createQuery(c);
        return q.getSingleResult();
//			return (RegisterUser) getEntityManager()
//				.createQuery("SELECT ru FROM RegisterUser ru where ru.login= ?").setParameter(0,userName).getResultList().get(0);
    }
}