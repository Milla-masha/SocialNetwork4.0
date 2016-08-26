package sjc.app.model.entity;

import sjc.app.model.entity.interfaces.PostEntity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "discriminator",
        discriminatorType = DiscriminatorType.STRING
)
@Table(name = "posts")
public class PostEntityImpl extends AbstractPersistable implements PostEntity
{
    private ImageEntityImpl image;
    private String text;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "fkPost", fetch = FetchType.LAZY)
    private List<LikeEntityImpl> likes;
    private UserEntityImpl userFrom;
    private Date date;

    public PostEntityImpl()
    {
        this.date = new Date();
    }

    @Column(name = "date")
    @Override
    public Date getDate()
    {
        return date;
    }

    @Column(name = "date")
    @Override
    public String getDateString()
    {
        if (date != null)
        {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            return formatter.format(date);
        } else return null;
    }

    @Override
    public void setDate(Date date)
    {
        this.date = date;
    }

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_media", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    @Override
    public ImageEntityImpl getImage()
    {
        return image;
    }

    @Override
    public void setImage(ImageEntityImpl image)
    {
        this.image = image;
    }

    @Column(name = "text")
    @Override
    public String getText()
    {
        return text;
    }

    @Override
    public void setText(String text)
    {
        this.text = text;
    }

    @Override
    public List<LikeEntityImpl> getLikes()
    {
        return likes;
    }

    @Override
    public void setLikes(List<LikeEntityImpl> likes)
    {
        this.likes = likes;
    }

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_user_from", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public UserEntityImpl getUserFrom()
    {
        return userFrom;
    }

    public void setUserFrom(UserEntityImpl userFrom)
    {
        this.userFrom = userFrom;
    }
}