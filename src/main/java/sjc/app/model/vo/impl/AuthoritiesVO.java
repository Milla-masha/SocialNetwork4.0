package sjc.app.model.vo.impl;

import sjc.app.model.vo.IAuthorities;

public class AuthoritiesVO implements IAuthorities
{
    private long id;
    private String authorities;
    private RegisterUserVO idU;

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

    public RegisterUserVO getIdU() {
        return idU;
    }

    public void setIdU(RegisterUserVO idU) {
        this.idU = idU;
    }
}
