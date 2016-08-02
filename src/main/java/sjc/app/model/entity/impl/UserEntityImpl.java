package sjc.app.model.entity.impl;

import sjc.app.model.entity.UserEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by psycl on 29.07.2016.
 */
@Entity
@Table(name = "users")
@DiscriminatorValue("USER")

public class UserEntityImpl extends AbstractPersistable implements UserEntity {

    @Column(name = "password")
    private String password;

    @Column(name = "login")
    private String login;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "skype")
    private String skype;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "birthdate")
    private Date birthday;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "city")
    private String city;

    @Column(name = "about")
    private String about;

    @Column(name = "sex")
    private String sex;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "friends", joinColumns = {
            @JoinColumn(name = "fk_user1", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_user2",
                    nullable = false, updatable = false)})
    private List<UserEntityImpl> friends;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<AuthoritiesImpl> authorities;

    @Override
    public List<UserEntityImpl> getFriends() {
        return friends;
    }

    @Override
    public void setFriends(List<UserEntityImpl> friends) {
        this.friends = friends;
    }

    @Override
    public void setAuthorities(List<AuthoritiesImpl> authorities) {

        this.authorities = authorities;
    }

    @Override
    public List<AuthoritiesImpl> getAuthorities() {
        return null;
    }

    @Override
    public void setLogin(String login) {

    }

    @Override
    public String getLogin() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void setLastName(String lastName) {

    }

    @Override
    public Date getBirthday() {
        return null;
    }

    @Override
    public void setBirthday(Date birthday) {

    }

    @Override
    public String getAvatar() {
        return null;
    }

    @Override
    public void setAvatar(String avatar) {

    }

    @Override
    public String getCity() {
        return null;
    }

    @Override
    public void setCity(String city) {

    }

    @Override
    public String getAbout() {
        return null;
    }

    @Override
    public void setAbout(String about) {

    }

    @Override
    public String getSex() {
        return null;
    }

    @Override
    public void setSex(String sex) {

    }

    @Override
    public String getMobile() {
        return null;
    }

    @Override
    public void setMobile(String mobile) {

    }

    @Override
    public String getSkype() {
        return null;
    }

    @Override
    public void setSkype(String skype) {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void setEmail(String email) {

    }
}
