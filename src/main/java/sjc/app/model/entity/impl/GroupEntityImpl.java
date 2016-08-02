package sjc.app.model.entity.impl;

import sjc.app.model.entity.GroupEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@DiscriminatorValue("GROUP")

public class GroupEntityImpl extends AbstractPersistable implements GroupEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "description")
    private String description;
    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "post_group",  joinColumns = {
            @JoinColumn(name = "fk_group", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "fk_post",
                    nullable = false, updatable = false) })
    private List<PostEntityImpl> posts;
    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "group_user",  joinColumns = {
            @JoinColumn(name = "fk_group", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "fk_user",
                    nullable = false, updatable = false) })
    private List<UserEntityImpl> users;

    public GroupEntityImpl() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PostEntityImpl> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntityImpl> posts) {
        this.posts = posts;
    }

    public List<UserEntityImpl> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntityImpl> users) {
        this.users = users;
    }
}
