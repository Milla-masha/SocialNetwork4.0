package sjc.app.dao;

import sjc.app.model.entity.DialogEntityImpl;

import java.util.List;

public interface DialogDao  extends GenericDao<DialogEntityImpl>
{
    List<DialogEntityImpl> getDialogsByUser(Long userId, int offset, int limit);
    Long getCountDialogsByUser(Long userId);
}
