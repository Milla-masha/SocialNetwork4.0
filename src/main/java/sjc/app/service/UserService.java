package sjc.app.service;

import sjc.app.model.vo.*;
import sjc.app.rest.exception.AlreadyExsistsException;
import sjc.app.rest.exception.NoAccessExseption;

import java.util.List;

public interface UserService
{
    boolean addUser(UserRegisterVO user) throws AlreadyExsistsException;

    InfoUserVO getInfoUserVO(String login,Long userId);

    InfoUserVO getInfoUserLogin(String login);

    InfoUserVO getUserById(String id);

    boolean editProfile(String login, UserFullVO user) throws AlreadyExsistsException;

    List<FriendVO> findUsersByFullName(String login,String fullName, int offset, int limit);

    Boolean getUserPassword(String email);

    boolean editUserPassword(PasswordVO password, String name) throws NoAccessExseption;

    Long getUserId(String login);
}
