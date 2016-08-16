package sjc.app.model.entity;

import sjc.app.model.entity.interfaces.GroupEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class GroupEntityImpl extends AbstractPersistable implements GroupEntity
{

    private String name;
    private ImageEntityImpl image;
    private String description;
    private UserEntityImpl owner;
    private List<PostGroupEntityImpl> posts;
    private List<UserEntityImpl> users = new ArrayList<>(0);

    public GroupEntityImpl()
    {
    }

    @Column(name = "name")
    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_media", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Override
    public ImageEntityImpl getImage()
    {
        return image;
    }

    @Override
    public void setImage(ImageEntityImpl image)
    {
        this.image = image;
    }

    @Column(name = "description")
    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "group_user", joinColumns = {
            @JoinColumn(name = "fk_group")},
            inverseJoinColumns = {@JoinColumn(name = "fk_user")})
    @Override
    public List<UserEntityImpl> getUsers()
    {
        return users;
    }

    @Override
    public void setUsers(List<UserEntityImpl> users)
    {
        this.users = users;
    }

    @Access(AccessType.PROPERTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    @Override
    public List<PostGroupEntityImpl> getPosts()
    {
        return posts;
    }

    @Override
    public void setPosts(List<PostGroupEntityImpl> posts)
    {
        this.posts = posts;
    }


    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Override
    public UserEntityImpl getOwner()
    {
        return owner;
    }

    @Override
    public void setOwner(UserEntityImpl owner)
    {
        this.owner = owner;
    }
}
