package sjc.app.model.vo;

public class GroupVO extends BaseVO
{
    private String name;
    private Integer folowers;
    private String image;
    private String description;
    private Integer isMember;
    private Integer isOwner;

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getFolowers()
    {
        return folowers;
    }

    public void setFolowers(Integer folowers)
    {
        this.folowers = folowers;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public Integer getIsMember()
    {
        return isMember;
    }

    public void setIsMember(Integer isMember)
    {
        this.isMember = isMember;
    }

    public Integer getIsOwner()
    {
        return isOwner;
    }

    public void setIsOwner(Integer isOwner)
    {
        this.isOwner = isOwner;
    }
}
