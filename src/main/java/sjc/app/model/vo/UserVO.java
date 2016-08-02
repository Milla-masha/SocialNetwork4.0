package sjc.app.model.vo;

import sjc.app.model.entity.impl.AuthoritiesImpl;

import java.util.Date;
import java.util.List;

public class UserVO {
    private Long id;

    private String password;

    private String login;

    private String mobile;

    private String skype;

    private String email;

    private String name;

    private String lastName;

    private Date birthday;

    private String avatar;

    private List<AuthoritiesImpl> authorities;

    public List<AuthoritiesImpl> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthoritiesImpl> authorities) {
        this.authorities = authorities;
    }

    public UserVO(Long id, String password, String login, List<AuthoritiesImpl> authorities, String mobile, String skype, String email, String name, String lastName, Date birthday, String avatar, String city, String about, String sex/*, List<UserVO> friends*/) {
        this.id = id;
        this.password = password;
        this.login = login;
        this.authorities = authorities;
        this.mobile = mobile;
        this.skype = skype;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.avatar = avatar;
        this.city = city;
        this.about = about;
        this.sex = sex;
     //   this.friends = friends;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<UserVO> getFriends() {
        return friends;
    }

    public void setFriends(List<UserVO> friends) {
        this.friends = friends;
    }

    private String city;

    private String about;

    private String sex;
    private List<UserVO> friends;

    public UserVO() {
    }

    public UserVO(Long id, String password, String login) {
        this.id = id;
        this.password = password;
        this.login = login;
    }

    public UserVO(Long id, String password, String login, List<UserVO> friends) {
        this.id = id;
        this.password = password;
        this.login = login;
        this.friends = friends;
    }


}
