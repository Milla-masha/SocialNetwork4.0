package sjc.app.service;

import sjc.app.repository.vo.InfoUserVO;

public interface InfoUserService
{
    InfoUserVO getInfoUserVO(Long userId);
}
