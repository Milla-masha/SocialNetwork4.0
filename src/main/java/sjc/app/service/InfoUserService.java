package sjc.app.service;

import sjc.app.repository.vo.IInfoUser;

public interface InfoUserService
{
    IInfoUser getInfoUserVO(Long userId);
}
