package sjc.app.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
public class Post extends AbstractPersistable {
    @Column(name = "image")
    private String image;
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserEntity fkUser;
    @Column(name = "text")
    private String text;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "posts")
    private List<Group> groups=new ArrayList<>(0);
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPost")
    private List<Like> likes;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "post_user", joinColumns = {
            @JoinColumn(name = "fk_post", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_user",
                    nullable = false, updatable = false)})
    private List<UserEntity> users=new ArrayList<>(0);

    public Post() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UserEntity getFkUser() {
        return fkUser;
    }

    public void setFkUser(UserEntity fkUser) {
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

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}