package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.NotificationEntityImpl;
import sjc.app.repository.dao.NotificationDao;

@Repository
public class NotificationDaoImpl extends GenericDaoImpl<NotificationEntityImpl> implements NotificationDao
{
    public NotificationDaoImpl()
    {
        super(NotificationEntityImpl.class);
    }
}
