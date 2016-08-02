package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.UserEntity;
import sjc.app.repository.dao.UserDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class UserDaoImpl extends GenericDaoImpl<UserEntity> implements UserDao {

	public UserDaoImpl() {
		super(UserEntity.class);
	}

	@Override
	public UserEntity findByName(String userName) {
		CriteriaBuilder cb=getEntityManager().getCriteriaBuilder();
		CriteriaQuery<UserEntity> c = cb.createQuery(UserEntity.class);
		Root<UserEntity> registerUser = c.from(UserEntity.class);
		Predicate condition = cb.equal(registerUser.get("login"), userName);
		c.where(condition);
		TypedQuery<UserEntity> q = getEntityManager().createQuery(c);
		return q.getSingleResult();
	}

}

