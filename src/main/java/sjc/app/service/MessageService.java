package sjc.app.service;

import sjc.app.model.vo.MessageDialogVO;
import sjc.app.rest.exception.NotFoundExseption;

public interface MessageService
{
    MessageDialogVO getMessages(String login, Long dialogId, int offset, int limit);
    Long getCountMassagesFromDialog(Long dialogId);
    void addMessage(String text, Long userId, Long dialogId) throws NotFoundExseption;
}
