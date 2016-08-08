package sjc.app.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class GroupEntityImpl extends AbstractPersistable{

    private String name;
    private ImageEntityImpl image;
    private String description;
    private UserEntityImpl owner;
    private List<PostGroupEntityImpl> posts;
    private List<UserEntityImpl> users=new ArrayList<>(0);

    public GroupEntityImpl() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_media", referencedColumnName = "id")
    @ManyToOne(optional = false)
    public ImageEntityImpl getImage() {
        return image;
    }

    public void setImage(ImageEntityImpl image) {
        this.image = image;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "group_user",  joinColumns = {
            @JoinColumn(name = "fk_group", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "fk_user",
                    nullable = false, updatable = false) })
    public List<UserEntityImpl> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntityImpl> users) {
        this.users = users;
    }

    @Access(AccessType.PROPERTY)
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "group")
    public List<PostGroupEntityImpl> getPosts() {
        return posts;
    }

    public void setPosts(List<PostGroupEntityImpl> posts) {
        this.posts = posts;
    }


    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    public UserEntityImpl getOwner() {
        return owner;
    }

    public void setOwner(UserEntityImpl owner) {
        this.owner = owner;
    }
}
