package sjc.app.model.entity.interfaces;

import sjc.app.model.entity.ImageEntityImpl;
import sjc.app.model.entity.PostGroupEntityImpl;
import sjc.app.model.entity.UserEntityImpl;

import javax.persistence.*;
import java.util.List;

/**
 * Created by psycl on 08.08.2016.
 */
public interface GroupEntity {
    @Column(name = "name")
    String getName();

    void setName(String name);

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_media", referencedColumnName = "id")
    @ManyToOne(optional = false)
    ImageEntityImpl getImage();

    void setImage(ImageEntityImpl image);

    @Column(name = "description")
    String getDescription();

    void setDescription(String description);

    @Access(AccessType.PROPERTY)
    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "group_user",  joinColumns = {
            @JoinColumn(name = "fk_group", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "fk_user",
                    nullable = false, updatable = false) })
    List<UserEntityImpl> getUsers();

    void setUsers(List<UserEntityImpl> users);

    @Access(AccessType.PROPERTY)
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "group")
    List<PostGroupEntityImpl> getPosts();

    void setPosts(List<PostGroupEntityImpl> posts);

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    UserEntityImpl getOwner();

    void setOwner(UserEntityImpl owner);
}
