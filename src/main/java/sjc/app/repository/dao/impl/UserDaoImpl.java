package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.entity.UserEntity;
import sjc.app.repository.dao.UserDao;

@Repository
public class UserDaoImpl extends GenericDaoImpl<UserEntity> implements UserDao {
	
	public UserEntity findByCredentials(String login, String password) {
		/*Criteria cr = getSession()
				.createCriteria(UserEntity.class, "registeruser")
				.add(Restrictions.eq("login", login))
				.add(Restrictions.eq("password", password));
		return (UserEntity) cr.uniqueResult();*/ return null;
	}

	@Override
	public UserEntity findByName(String userName) {
		return (UserEntity) getEntityManager()
				.createQuery("SELECT ru FROM UserEntity ru where ru.login= ?").setParameter(0,userName).getResultList().get(0);

		//return (UserEntity) query.getResultList().get(0);
	}
}

