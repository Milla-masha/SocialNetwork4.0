package sjc.app.service;


import sjc.app.model.vo.UserSmallVO;

import java.util.List;

public interface BlackListService
{
    List<UserSmallVO> getBlackList(Long userId, int offset, int limit);

    void addBlackList(Long idUserOwner, Long bUserId);

    void deleteBlackList(Long idUserOwner, Long bUserId);

    Long getCountBlackUser(Long userId);
}
