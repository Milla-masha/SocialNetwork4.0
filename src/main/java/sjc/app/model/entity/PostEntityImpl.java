package sjc.app.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "discriminator",
        discriminatorType = DiscriminatorType.STRING
)
@Table(name = "posts")
public class PostEntityImpl extends AbstractPersistable
{

    private ImageEntityImpl image;
    private String text;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPost", fetch = FetchType.LAZY)
    private List<LikeEntityImpl> likes;
    private UserEntityImpl userFrom;

    public PostEntityImpl()
    {
    }

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_media", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    public ImageEntityImpl getImage()
    {
        return image;
    }

    public void setImage(ImageEntityImpl image)
    {
        this.image = image;
    }

    @Column(name = "text")
    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    //@Access(AccessType.PROPERTY)
    public List<LikeEntityImpl> getLikes()
    {
        return likes;
    }

    public void setLikes(List<LikeEntityImpl> likes)
    {
        this.likes = likes;
    }

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_user_from", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    public UserEntityImpl getUserFrom()
    {
        return userFrom;
    }

    public void setUserFrom(UserEntityImpl userFrom)
    {
        this.userFrom = userFrom;
    }
}