package sjc.app.model.entity.impl;

import sjc.app.model.entity.PostEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
@DiscriminatorColumn(name = "author", discriminatorType = DiscriminatorType.STRING)
public class PostEntityImpl extends AbstractPersistable implements PostEntity {

    @Column(name = "text")
    private String text;

    @Column(name = "author")
    private String author;

    @Column(name = "image")
    private String image;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "post_group", joinColumns = {
            @JoinColumn(name = "fk_post", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_group",
                    nullable = false, updatable = false)})
    private List<GroupEntityImpl> groupEntityImpls;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPost")
    private List<LikeEntityImpl> likes;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "post_user", joinColumns = {
            @JoinColumn(name = "fk_post", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_user",
                    nullable = false, updatable = false)})
    private List<PostUser> users;

    public PostEntityImpl() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String  author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<GroupEntityImpl> getGroupEntityImpls() {
        return groupEntityImpls;
    }

    public void setGroupEntityImpls(List<GroupEntityImpl> groupEntityImpls) {
        this.groupEntityImpls = groupEntityImpls;
    }

    public List<LikeEntityImpl> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeEntityImpl> likes) {
        this.likes = likes;
    }

    public List<PostUser> getUsers() {
        return users;
    }

    public void setUsers(List<PostUser> users) {
        this.users = users;
    }
}