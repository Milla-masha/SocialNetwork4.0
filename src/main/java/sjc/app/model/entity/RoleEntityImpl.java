package sjc.app.model.entity;

import javax.persistence.*;


@Entity
@Table(name = "roles")
public class RoleEntityImpl extends AbstractPersistable {

    @Column(name = "authorities")
    private String role;
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntityImpl user;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserEntityImpl getUser() {
        return user;
    }

    public void setUser(UserEntityImpl user) {
        this.user = user;
    }
}
