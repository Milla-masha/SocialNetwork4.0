package sjc.app.model.vo;

import java.util.List;

public class UserVO extends BaseVO
{

    private String password;
    private String login;
    private List<UserVO> friends;

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public List<UserVO> getFriends()
    {
        return friends;
    }

    public void setFriends(List<UserVO> friends)
    {
        this.friends = friends;
    }

}
