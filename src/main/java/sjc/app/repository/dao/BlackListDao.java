package sjc.app.repository.dao;

import sjc.app.model.entity.UserEntityImpl;

import java.util.List;

public interface BlackListDao
{
    List<UserEntityImpl> getBlackList(Long idUser, int offset, int limit);

    void addBlackList(Long ownerId, Long blackUserId);

    void deleteBlackList(Long ownerId, Long blackUserId);
}
