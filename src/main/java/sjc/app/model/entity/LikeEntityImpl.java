package sjc.app.model.entity;

import sjc.app.model.entity.interfaces.LikeEntity;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class LikeEntityImpl extends AbstractPersistable implements LikeEntity
{
    @Column(name = "is_like")
    private int isLike;
    @JoinColumn(name = "fk_post", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    protected PostEntityImpl fkPost;
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserEntityImpl user;

    public LikeEntityImpl()
    {
    }

    @Override
    public int getIsLike()
    {
        return isLike;
    }

    @Override
    public void setIsLike(int isLike)
    {
        this.isLike = isLike;
    }

    @Override
    public PostEntityImpl getFkPost()
    {
        return fkPost;
    }

    @Override
    public void setFkPost(PostEntityImpl fkPost)
    {
        this.fkPost = fkPost;
    }

    @Override
    public UserEntityImpl getUser()
    {
        return user;
    }

    @Override
    public void setUser(UserEntityImpl fkUser)
    {
        this.user = fkUser;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LikeEntityImpl that = (LikeEntityImpl) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;

    }

    @Override
    public int hashCode()
    {
        return getId() != null ? getId().hashCode() : 0;
    }
}