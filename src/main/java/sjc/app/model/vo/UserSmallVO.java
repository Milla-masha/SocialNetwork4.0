package sjc.app.model.vo;


public class UserSmallVO extends BaseVO
{

    private String name;
    private String lastName;
    private String avatar;
    private Boolean isOnline;

    public Boolean getOnline()
    {
        return isOnline;
    }

    public void setOnline(Boolean isOnline)
    {
        this.isOnline = isOnline;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

}
