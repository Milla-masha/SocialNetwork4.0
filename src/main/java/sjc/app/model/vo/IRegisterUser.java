package sjc.app.model.vo;


import sjc.app.model.vo.impl.RegisterUserVO;

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
