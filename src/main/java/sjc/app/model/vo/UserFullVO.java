package sjc.app.model.vo;

public class UserFullVO extends BaseVO
{
    private String name;
    private String email;
    private String skype;
    private Integer mobile;
    private String lastName;
    private Integer sex;
    private Long avatarId;
    private String birthdate;
    private String city;
    private String about;

    public UserFullVO()
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getSkype()
    {
        return skype;
    }

    public void setSkype(String skype)
    {
        this.skype = skype;
    }

    public int getMobile()
    {
        return mobile;
    }

    public void setMobile(int mobile)
    {
        this.mobile = mobile;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Integer getSex()
    {
        return sex;
    }

    public void setSex(Integer sex)
    {
        this.sex = sex;
    }

    public Long getAvatarId()
    {
        return avatarId;
    }

    public void setAvatarId(Long avatarId)
    {
        this.avatarId = avatarId;
    }

    public String getBirthdate()
    {
        return birthdate;
    }

    public void setBirthdate(String birthdate)
    {
        this.birthdate = birthdate;
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
}
