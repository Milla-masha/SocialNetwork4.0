package sjc.app.repository.vo;


import sjc.app.repository.vo.impl.RegisterUserVO;

import java.util.List;

public interface IRegisterUser
{
    String getPassword();

    void setPassword(String password);

    String getLogin();

    void setLogin(String login);

    long getId();

    void setId(long id);

    List<RegisterUserVO> getFriends();

    void setFriends(List<RegisterUserVO> friends);
}
