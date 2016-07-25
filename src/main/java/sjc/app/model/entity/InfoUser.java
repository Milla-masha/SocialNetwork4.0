package sjc.app.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "info_user")
public class InfoUser extends AbstractPersistable {

    @JoinColumn(name = "fk_registeruser", referencedColumnName = "id")
    @OneToOne(optional = false,fetch = FetchType.LAZY)
    private RegisterUser user;

    public InfoUser() {
    }

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "city")
    private String city;

    @Column(name = "about")
    private String about;

    @Column(name = "sex")
    private String sex;

    public RegisterUser getUser() {
        return user;
    }

    public void setUser(RegisterUser user) {
        this.user = user;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
