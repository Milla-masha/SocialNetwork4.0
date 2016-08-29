package sjc.app.repository.dao;

import sjc.app.model.entity.MessageEntityImpl;

import java.util.List;

public interface MessageDao extends GenericDao<MessageEntityImpl>
{
    List<MessageEntityImpl> getMessageByDialog(Long dialogId, int offset, int limit);
    Long getCountMessagesByDialog(Long dialogId);
}
