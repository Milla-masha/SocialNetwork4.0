package sjc.app.service;


import sjc.app.model.vo.UserSmallVO;

import java.util.List;

public interface BlackListService
{
    List<UserSmallVO> getBlackList(Long userId, int offset, int limit);

    void addBlackList(Long idUserOwner, Long idBlackUser);

    void deleteBlackList(Long idUserOwner, Long idBlackUser);

    Long getCountBlackUser(Long userId);
}
