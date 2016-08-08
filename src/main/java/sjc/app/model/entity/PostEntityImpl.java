package sjc.app.model.entity;

import sjc.app.model.entity.interfaces.PostEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "discriminator",
        discriminatorType = DiscriminatorType.STRING
)
@Table(name = "posts")
public class PostEntityImpl extends AbstractPersistable implements PostEntity {

    private ImageEntityImpl image;
    private String text;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPost", fetch = FetchType.LAZY)
    private List<LikeEntityImpl> likes;

    public PostEntityImpl() {
    }

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_media", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    @Override
    public ImageEntityImpl getImage() {
        return image;
    }

    @Override
    public void setImage(ImageEntityImpl image) {
        this.image = image;
    }

    @Column(name = "text")
    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    //@Access(AccessType.PROPERTY)
    @Override
    public List<LikeEntityImpl> getLikes() {
        return likes;
    }

    @Override
    public void setLikes(List<LikeEntityImpl> likes) {
        this.likes = likes;
    }

}