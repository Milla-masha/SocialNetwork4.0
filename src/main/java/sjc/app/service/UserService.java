package sjc.app.service;

import sjc.app.model.vo.InfoUserVO;
import sjc.app.model.vo.UserRegisterVO;

public interface UserService
{
    boolean addUser(UserRegisterVO user);

    InfoUserVO getInfoUserVO(Long userId);

    InfoUserVO getInfoUserVOLogin(String login);

}
