package sjc.app.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Like extends AbstractPersistable{
    @Column(name = "is_like")
    private int isLike;
    @JoinColumn(name = "fk_post", referencedColumnName = "id")
    @ManyToOne(optional = false)
    protected Post fkPost;
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserEntity fkUser;

    public Like() {
    }

    public int getIsLike() {
        return isLike;
    }

    public void setIsLike(int isLike) {
        this.isLike = isLike;
    }

    public Post getFkPost() {
        return fkPost;
    }

    public void setFkPost(Post fkPost) {
        this.fkPost = fkPost;
    }

    public UserEntity getFkUser() {
        return fkUser;
    }

    public void setFkUser(UserEntity fkUser) {
        this.fkUser = fkUser;
    }
}