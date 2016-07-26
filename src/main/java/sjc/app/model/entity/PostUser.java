package sjc.app.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post_user")
public class PostUser extends AbstractPersistable{
    @JoinColumn(name = "fk_post", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Post fkPost;
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserEntity fkUser;

    public PostUser() {
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
