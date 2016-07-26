package sjc.app.model.vo;

import java.util.Date;

public class InfoUserVO {

    private String name;

    private String lastName;

    private Date birthday;

    private String avatar;

    private String city;

    private String about;

    private ContactUserVO contactUser;

    public InfoUserVO(String name, String lastName, Date birthday, String avatar, String city, String about, ContactUserVO contactUser) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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
