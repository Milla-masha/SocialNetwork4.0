package sjc.app.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "post")
public class Post extends AbstractPersistable {
    @Column(name = "image")
    private String image;
    @Column(name = "fk_user")
    private Integer fkUser;
    @Column(name = "text")
    private String text;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "post_group", joinColumns = {
            @JoinColumn(name = "fk_post", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_group",
                    nullable = false, updatable = false)})
    private List<Group> groups;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPost")
    private List<Like> likes;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "post_user", joinColumns = {
            @JoinColumn(name = "fk_post", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_user",
                    nullable = false, updatable = false)})
    private List<PostUser> users;

    public Post() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getFkUser() {
        return fkUser;
    }

    public void setFkUser(Integer fkUser) {
        this.fkUser = fkUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<PostUser> getUsers() {
        return users;
    }

    public void setUsers(List<PostUser> users) {
        this.users = users;
    }
}