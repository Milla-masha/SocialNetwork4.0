package sjc.app.model.entity;

import javax.persistence.*;

@Entity
@Table(name="posts")
@DiscriminatorValue("GROUP")
public class PostGroupEntityImpl extends PostEntityImpl
{

    private GroupEntityImpl group;

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_group", referencedColumnName = "id")
    @ManyToOne(optional = false)
    public GroupEntityImpl getGroup() {
        return group;
    }

    public void setGroup(GroupEntityImpl group) {
        this.group = group;
    }
}
