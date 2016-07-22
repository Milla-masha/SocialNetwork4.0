package sjc.app.repository.vo;

/**
 * Created by Aleks69 on 12.07.2016.
 */
    public class AuthoritiesVO {

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
