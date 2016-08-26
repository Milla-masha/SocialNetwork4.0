package sjc.app.service;

import sjc.app.model.vo.NotificationVO;

public interface NotificationService
{
    void addTokenFromNotification(String login,NotificationVO notification);
}
