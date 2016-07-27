package sjc.app.model.vo;

public class AuthoritiesVO
{
    private long id;
    private String authorities;
    private UserVO idU;

    public AuthoritiesVO() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public UserVO getIdU() {
        return idU;
    }

    public void setIdU(UserVO idU) {
        this.idU = idU;
    }
}
