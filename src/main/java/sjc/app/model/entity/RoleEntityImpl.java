package sjc.app.model.entity;

import sjc.app.model.entity.interfaces.RoleEntity;

import javax.persistence.*;


@Entity
@Table(name = "roles")
public class RoleEntityImpl extends AbstractPersistable implements RoleEntity
{

    @Column(name = "authorities")
    @Enumerated(EnumType.STRING)
    private Role role;
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntityImpl user;

    @Override
    public Role getRole()
    {
        return role;
    }

    @Override
    public void setRole(Role role)
    {
        this.role = role;
    }

    @Override
    public UserEntityImpl getUser()
    {
        return user;
    }

    @Override
    public void setUser(UserEntityImpl user)
    {
        this.user = user;
    }
}
