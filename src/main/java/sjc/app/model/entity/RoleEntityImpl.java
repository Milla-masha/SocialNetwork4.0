package sjc.app.model.entity;

import javax.persistence.*;


@Entity
@Table(name = "roles")
public class RoleEntityImpl extends AbstractPersistable {

    private String role;
    private UserEntityImpl user;

    @Column(name = "authorities")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    public UserEntityImpl getUser() {
        return user;
    }

    public void setUser(UserEntityImpl user) {
        this.user = user;
    }
}
