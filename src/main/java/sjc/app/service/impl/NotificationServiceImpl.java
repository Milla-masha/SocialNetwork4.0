package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.dao.NotificationDao;
import sjc.app.dao.UserDao;
import sjc.app.model.entity.NotificationEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.vo.NotificationVO;
import sjc.app.service.NotificationService;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class NotificationServiceImpl implements NotificationService
{
    @Autowired
    private NotificationDao notificationDao;
    @Autowired
    private UserDao userDao;

    @Override
    public void addTokenFromNotification(String login, NotificationVO notification)
    {
        UserEntityImpl user = userDao.findByName(login);
        NotificationEntityImpl notificationEntity = notificationDao.findByToken(notification.getToken());
        if (notificationEntity != null)
        {
            notificationDao.delete(notificationEntity.getId());
        }
        if (user.getNotification() != null)
        {
            notificationEntity = user.getNotification();
        } else
        {
            notificationEntity = new NotificationEntityImpl();
        }
        notificationEntity.setToken(notification.getToken());
        notificationEntity.setUser(user);
        notificationDao.update(notificationEntity);
    }
}
