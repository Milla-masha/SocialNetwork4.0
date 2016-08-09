package sjc.app.model.entity;

import sjc.app.model.entity.interfaces.LikeEntity;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class LikeEntityImpl extends AbstractPersistable implements LikeEntity {
    @Column(name = "is_like")
    private int isLike;
    @JoinColumn(name = "fk_post", referencedColumnName = "id")
    @ManyToOne(optional = false)
    protected PostEntityImpl fkPost;
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserEntityImpl fkUser;

    public LikeEntityImpl() {
    }

    @Override
    public int getIsLike() {
        return isLike;
    }

    @Override
    public void setIsLike(int isLike) {
        this.isLike = isLike;
    }

    @Override
    public PostEntityImpl getFkPost() {
        return fkPost;
    }

    @Override
    public void setFkPost(PostEntityImpl fkPost) {
        this.fkPost = fkPost;
    }

    @Override
    public UserEntityImpl getFkUser() {
        return fkUser;
    }

    @Override
    public void setFkUser(UserEntityImpl fkUser) {
        this.fkUser = fkUser;
    }
}