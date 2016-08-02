package sjc.app.model.entity.impl;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post_group")
public class PostGroup extends AbstractPersistable{
    @JoinColumn(name = "fk_post", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PostEntityImpl fkPost;
    @JoinColumn(name = "fk_group", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GroupEntityImpl fkGroupEntityImpl;

    public PostGroup() {
    }

    public PostEntityImpl getFkPost() {
        return fkPost;
    }

    public void setFkPost(PostEntityImpl fkPost) {
        this.fkPost = fkPost;
    }

    public GroupEntityImpl getFkGroupEntityImpl() {
        return fkGroupEntityImpl;
    }

    public void setFkGroupEntityImpl(GroupEntityImpl fkGroupEntityImpl) {
        this.fkGroupEntityImpl = fkGroupEntityImpl;
    }

}
