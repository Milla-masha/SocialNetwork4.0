package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.ContactUser;
import sjc.app.repository.dao.ContactUserDao;

@Repository
public class ContactUserDaoImpl extends GenericDaoImpl<ContactUser> implements ContactUserDao {
}
