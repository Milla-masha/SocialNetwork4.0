package sjc.app.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "group")
public class Group extends AbstractPersistable{

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
    private List<Post> posts;
    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "group_user",  joinColumns = {
            @JoinColumn(name = "fk_group", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "fk_user",
                    nullable = false, updatable = false) })
    private List<RegisterUser> users;

    public Group() {
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<RegisterUser> getUsers() {
        return users;
    }

    public void setUsers(List<RegisterUser> users) {
        this.users = users;
    }
}
