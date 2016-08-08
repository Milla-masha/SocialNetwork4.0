package sjc.app.model.entity;

import sjc.app.model.entity.interfaces.PostGroupEntity;

import javax.persistence.*;

@Entity
@Table(name="posts")
@DiscriminatorValue("GROUP")
public class PostGroupEntityImpl extends PostEntityImpl implements PostGroupEntity
{

    private GroupEntityImpl group;

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_group", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Override
    public GroupEntityImpl getGroup() {
        return group;
    }
    @Override
    public void setGroup(GroupEntityImpl group) {
        this.group = group;
    }
}
