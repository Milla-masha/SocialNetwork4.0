package sjc.app.dao;

import sjc.app.model.entity.MessageEntityImpl;

import java.util.List;

public interface MessageDao extends GenericDao<MessageEntityImpl>
{
    List<MessageEntityImpl> getMessageByDialog(Long dialogId, int offset, int limit);

    MessageEntityImpl getLastMessageByDialog(Long dialogId);

    Long getCountMessagesByDialog(Long dialogId);
}
