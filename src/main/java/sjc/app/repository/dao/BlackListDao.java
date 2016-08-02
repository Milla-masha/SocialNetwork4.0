package sjc.app.repository.dao;

import sjc.app.model.entity.InfoUser;

import java.util.List;

public interface BlackListDao
{
    List<InfoUser> getBlackList(Long idUser, int offset, int limit);
    void addBlackList(Long ownerId, Long blackUserId);
    void deleteBlackList(Long ownerId, Long blackUserId);
}
