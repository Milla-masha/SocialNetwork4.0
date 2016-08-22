package sjc.app.model.vo;

public class GroupVO extends BaseVO
{
    private String name;
    private Integer folowers;
    private String image;
    private String description;
    private Boolean isMember;
    private Boolean isOwner;

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

    public Boolean getMember()
    {
        return isMember;
    }

    public void setMember(Boolean member)
    {
        isMember = member;
    }

    public Boolean getOwner()
    {
        return isOwner;
    }

    public void setOwner(Boolean owner)
    {
        isOwner = owner;
    }
}
