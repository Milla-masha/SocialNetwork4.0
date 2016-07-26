package sjc.app.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post_group")
public class PostGroup extends AbstractPersistable{
    @JoinColumn(name = "fk_post", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Post fkPost;
    @JoinColumn(name = "fk_group", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Group fkGroup;

    public PostGroup() {
    }

    public Post getFkPost() {
        return fkPost;
    }

    public void setFkPost(Post fkPost) {
        this.fkPost = fkPost;
    }

    public Group getFkGroup() {
        return fkGroup;
    }

    public void setFkGroup(Group fkGroup) {
        this.fkGroup = fkGroup;
    }

}
