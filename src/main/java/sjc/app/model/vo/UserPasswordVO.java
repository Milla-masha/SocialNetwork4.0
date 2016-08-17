package sjc.app.model.vo;

/**
 * Created by psycl on 17.08.2016.
 */
public class UserPasswordVO extends BaseVO
{
    private String password;

    public UserPasswordVO()
    {

    }

    public UserPasswordVO(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }


}

