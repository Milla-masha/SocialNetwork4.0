package sjc.app.model.entity;

import sjc.app.model.entity.interfaces.RoleEntity;

import javax.persistence.*;


@Entity
@Table(name = "roles")
public class RoleEntityImpl extends AbstractPersistable implements RoleEntity {

    @Column(name = "authorities")
    private String role;
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntityImpl user;

    @Override

    public String getRole() {
        return role;
    }

    @Override

    public void setRole(String role) {
        this.role = role;
    }

    @Override

    public UserEntityImpl getUser() {
        return user;
    }

    @Override

    public void setUser(UserEntityImpl user) {
        this.user = user;
    }
}
