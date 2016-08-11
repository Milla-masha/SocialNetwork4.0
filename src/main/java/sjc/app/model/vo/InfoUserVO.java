package sjc.app.model.vo;

public class InfoUserVO extends BaseVO
{

    private String name;

    private String lastName;

    private String birthday;

    private String avatar;

    private String city;

    private String about;

    private Integer sex;

    private ContactUserVO contactUser;

    private Integer isFriend;

    public Integer getIsFriend()
    {
        return isFriend;
    }

    public void setIsFriend(Integer isFriend)
    {
        this.isFriend = isFriend;
    }

    public InfoUserVO()
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

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getAbout()
    {
        return about;
    }

    public void setAbout(String about)
    {
        this.about = about;
    }

    public ContactUserVO getContactUser()
    {
        return contactUser;
    }

    public void setContactUser(ContactUserVO contactUser)
    {
        this.contactUser = contactUser;
    }

    public Integer getSex()
    {
        return sex;
    }

    public void setSex(Integer sex)
    {
        this.sex = sex;
    }
}
