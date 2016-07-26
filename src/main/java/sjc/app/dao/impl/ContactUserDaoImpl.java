package sjc.app.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.dao.ContactUserDao;
import sjc.app.model.entity.ContactUser;

@Repository
public class ContactUserDaoImpl extends GenericDaoImpl<ContactUser> implements ContactUserDao {
}
