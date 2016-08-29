package sjc.app.service;

import sjc.app.model.vo.DialogVO;
import sjc.app.rest.exception.NotFoundExseption;

import java.util.List;

public interface DialogService
{
    List<DialogVO> getDialogs(String login, int offset, int limit);
    Long getCountDialogsFromUser(String login);
    Long getDialogIdByUser(String login,Long userId) throws NotFoundExseption;
}
