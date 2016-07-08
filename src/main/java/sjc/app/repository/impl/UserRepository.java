package sjc.app.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import sjc.app.repository.dao.UserDAO;
import sjc.app.repository.entity.User;
import sjc.app.repository.hibernate.AbstractHibernateDAO;

@Repository
public class UserRepository extends AbstractHibernateDAO<User> implements UserDAO {
	
	@Override
	public User findById(long userId) {
		Criteria cr = getSession()
				.createCriteria(User.class, "user")
				.add(Restrictions.eq("idUser", userId));
		return (User) cr.uniqueResult();
	}
	
	public User findByCredentials(String login, String password) {
		Criteria cr = getSession()
				.createCriteria(User.class, "user")
				.add(Restrictions.eq("login", login))
				.add(Restrictions.eq("password", password));
		return (User) cr.uniqueResult();
	}

	@Override
	public User findByName(String userName) {
		Criteria cr = getSession()
				.createCriteria(User.class, "user")
				.add(Restrictions.like("login", userName));
		return (User) cr.uniqueResult();
	}
}

