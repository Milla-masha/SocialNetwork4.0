package sjc.app.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "notifications")
public class NotificationEntityImpl extends AbstractPersistable
{
    @Column(name = "token")
    private String token;
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserEntityImpl user;

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public UserEntityImpl getUser()
    {
        return user;
    }

    public void setUser(UserEntityImpl user)
    {
        this.user = user;
    }
}
