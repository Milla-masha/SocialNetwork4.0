package sjc.app.service;


import sjc.app.model.vo.UserSmallVO;
import sjc.app.rest.exception.AlreadyExsistsException;
import sjc.app.rest.exception.NoAccessExseption;
import sjc.app.rest.exception.NotFoundExseption;

import java.util.List;

public interface BlackListService
{
    List<UserSmallVO> getBlackList(Long userId, int offset, int limit);

    void addBlackList(Long idUserOwner, Long bUserId) throws NotFoundExseption, AlreadyExsistsException, NoAccessExseption;

    void deleteBlackList(Long idUserOwner, Long bUserId) throws NotFoundExseption;

    Long getCountBlackUser(Long userId);
}
