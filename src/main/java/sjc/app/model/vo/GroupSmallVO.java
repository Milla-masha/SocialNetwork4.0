package sjc.app.model.vo;

public class GroupSmallVO extends BaseVO
{
    String name;
    Long fkImage;
    private String description;

    public GroupSmallVO()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getFkImage()
    {
        return fkImage;
    }

    public void setFkImage(Long fkImage)
    {
        this.fkImage = fkImage;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
