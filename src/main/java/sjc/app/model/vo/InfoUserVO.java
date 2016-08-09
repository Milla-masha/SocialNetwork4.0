package sjc.app.model.vo;
public class InfoUserVO {

    private Long id;

    private String name;

    private String lastName;

    private String birthday;

    private String avatar;

    private String city;

    private String about;

    private ContactUserVO contactUser;

    public InfoUserVO(Long id,String name, String lastName, String birthday, String avatar, String city, String about, ContactUserVO contactUser) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.avatar = avatar;
        this.city = city;
        this.about = about;
        this.contactUser = contactUser;
    }

    public InfoUserVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String  getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public ContactUserVO getContactUser() {
        return contactUser;
    }

    public void setContactUser(ContactUserVO contactUser) {
        this.contactUser = contactUser;
    }

}
