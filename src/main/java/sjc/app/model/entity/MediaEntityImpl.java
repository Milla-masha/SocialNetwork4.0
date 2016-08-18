package sjc.app.model.entity;

import sjc.app.model.entity.interfaces.MediaEntity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "discriminator",
        discriminatorType = DiscriminatorType.STRING
)
@Table(name = "media")
public class MediaEntityImpl extends AbstractPersistable implements MediaEntity
{
    private String url;

    @Column(name = "url")
    @Override
    public String getUrl()
    {
        return url;
    }

    @Override
    public void setUrl(String url)
    {
        this.url = url;
    }

}
