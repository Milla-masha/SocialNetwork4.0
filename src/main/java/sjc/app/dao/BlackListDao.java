package sjc.app.dao;

import sjc.app.model.entity.UserEntityImpl;

import java.util.List;

public interface BlackListDao
{
    List<UserEntityImpl> getBlackList(Long idUser, int offset, int limit);

    Long getCountBlackList(Long idUser);
}
