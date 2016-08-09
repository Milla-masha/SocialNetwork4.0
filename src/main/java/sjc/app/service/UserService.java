package sjc.app.service;

import sjc.app.model.vo.InfoUserVO;
import sjc.app.model.vo.UserFullVO;
import sjc.app.model.vo.UserRegisterVO;

public interface UserService
{
    boolean addUser(UserRegisterVO user);

    InfoUserVO getInfoUserVO(Long userId);

    InfoUserVO getInfoUserLogin(String login);

    InfoUserVO getInfoUserVOLogin(String login);

    boolean editProfile(String login, UserFullVO user);
}
