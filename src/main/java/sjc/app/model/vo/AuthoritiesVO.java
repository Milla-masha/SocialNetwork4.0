package sjc.app.model.vo;

/**
 * Created by Aleks69 on 12.07.2016.
 */


public class AuthoritiesVO {
    private Long id;
    private String authorities;
    private UserVO idU;

    public AuthoritiesVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
