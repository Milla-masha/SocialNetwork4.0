package sjc.app.model.vo;

public class AuthoritiesVO extends BaseVO
{
    private String authorities;
    private UserVO idU;

    public String getAuthorities()
    {
        return authorities;
    }

    public void setAuthorities(String authorities)
    {
        this.authorities = authorities;
    }

    public UserVO getIdU()
    {
        return idU;
    }

    public void setIdU(UserVO idU)
    {
        this.idU = idU;
    }
}
