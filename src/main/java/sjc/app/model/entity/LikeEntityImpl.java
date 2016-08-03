package sjc.app.model.entity;
import javax.persistence.*;

@Entity
@Table(name = "likes")
public class LikeEntityImpl extends AbstractPersistable{
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

    public int getIsLike() {
        return isLike;
    }

    public void setIsLike(int isLike) {
        this.isLike = isLike;
    }

    public PostEntityImpl getFkPost() {
        return fkPost;
    }

    public void setFkPost(PostEntityImpl fkPost) {
        this.fkPost = fkPost;
    }

    public UserEntityImpl getFkUser() {
        return fkUser;
    }

    public void setFkUser(UserEntityImpl fkUser) {
        this.fkUser = fkUser;
    }
}