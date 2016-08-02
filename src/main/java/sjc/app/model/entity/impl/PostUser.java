package sjc.app.model.entity.impl;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post_user")
public class PostUser extends AbstractPersistable{
    @JoinColumn(name = "fk_post", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PostEntityImpl fkPost;
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserEntityImpl fkUser;

    public PostUser() {
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
