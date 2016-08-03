package sjc.app.model.entity;

import javax.persistence.*;

@Entity
@Table(name="posts")
@DiscriminatorValue("USER")
public class PostUserEntityImpl extends PostEntityImpl
{
    private UserEntityImpl user;

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    public UserEntityImpl getUser() {
        return user;
    }

    public void setUser(UserEntityImpl user) {
        this.user = user;
    }
}
