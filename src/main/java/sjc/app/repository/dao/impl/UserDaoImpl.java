package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.entity.RegisterUser;
import sjc.app.repository.dao.UserDao;

@Repository
public class UserDaoImpl extends GenericDaoImpl<RegisterUser> implements UserDao {
	
	public RegisterUser findByCredentials(String login, String password) {
		/*Criteria cr = getSession()
				.createCriteria(RegisterUser.class, "registeruser")
				.add(Restrictions.eq("login", login))
				.add(Restrictions.eq("password", password));
		return (RegisterUser) cr.uniqueResult();*/ return null;
	}

	@Override
	public RegisterUser findByName(String userName) {
		return (RegisterUser) getEntityManager()
				.createQuery("SELECT ru FROM RegisterUser ru where ru.login= ?").setParameter(0,userName).getResultList().get(0);

		//return (RegisterUser) query.getResultList().get(0);
	}
}

