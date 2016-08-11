package sjc.app.service;

import sjc.app.model.vo.FriendVO;
import sjc.app.model.vo.InfoUserVO;
import sjc.app.model.vo.UserFullVO;
import sjc.app.model.vo.UserRegisterVO;

import java.util.List;

public interface UserService
{
    boolean addUser(UserRegisterVO user);

    InfoUserVO getInfoUserVO(String login,Long userId);

    InfoUserVO getInfoUserLogin(String login);

    boolean editProfile(String login, UserFullVO user);

    List<FriendVO> findUsersByFullName(String login,String fullName, int offset, int limit);
}
