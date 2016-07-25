package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.entity.RegisterUser;
import sjc.app.repository.dao.UserDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class UserDaoImpl extends GenericDaoImpl<RegisterUser> implements UserDao {

	@Override
	public RegisterUser findByName(String userName) {
		CriteriaBuilder cb=getEntityManager().getCriteriaBuilder();
		CriteriaQuery<RegisterUser> c = cb.createQuery(RegisterUser.class);
		Root<RegisterUser> registerUser = c.from(RegisterUser.class);
		Predicate condition = cb.equal(registerUser.get("login"), userName);
		c.where(condition);
		TypedQuery<RegisterUser> q = getEntityManager().createQuery(c);
		return q.getSingleResult();
//			return (RegisterUser) getEntityManager()
//				.createQuery("SELECT ru FROM RegisterUser ru where ru.login= ?").setParameter(0,userName).getResultList().get(0);
	}
}

