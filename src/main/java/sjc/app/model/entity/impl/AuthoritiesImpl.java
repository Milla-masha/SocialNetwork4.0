package sjc.app.model.entity.impl;

import sjc.app.model.entity.Authorities;

import javax.persistence.*;


@Entity
@Table(name = "roles")
public class AuthoritiesImpl extends AbstractPersistable implements Authorities {

    private String authorities;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntityImpl userId;

    @Column(name = "authorities")
    @Override
    public String getAuthorities() {
        return authorities;
    }
    @Override
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    @Override
    public UserEntityImpl getUserId() {
        return userId;
    }

    @Override
    public void setUserId(UserEntityImpl user_id) {
        this.userId = user_id;
    }
}
