package sjc.app.model.entity;

import sjc.app.model.entity.interfaces.PostUserEntity;

import javax.persistence.*;

@Entity
@Table(name="posts")
@DiscriminatorValue("USER")
public class PostUserEntityImpl extends PostEntityImpl implements PostUserEntity
{
    private UserEntityImpl user;

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Override
    public UserEntityImpl getUser() {
        return user;
    }

    @Override
    public void setUser(UserEntityImpl user) {
        this.user = user;
    }
}
