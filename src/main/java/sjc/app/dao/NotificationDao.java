package sjc.app.dao;

import sjc.app.model.entity.NotificationEntityImpl;

public interface NotificationDao extends GenericDao<NotificationEntityImpl>
{
    NotificationEntityImpl findByToken(String token);
}
