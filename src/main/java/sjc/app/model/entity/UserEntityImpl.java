package sjc.app.model.entity;

import sjc.app.model.entity.interfaces.UserEntity;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntityImpl extends AbstractPersistable implements UserEntity {

    private String password;
    private String login;
    private String name;
    private String email;
    private String skype;
    private int mobile;
    private String lastName;
    private String sex;
    private ImageEntityImpl avatar;
    private Date birthdate;
    private String city;
    private String about;
    private int enabled;
    private List<UserEntityImpl> friends = new ArrayList<>(0);
    private List<UserEntityImpl> blackListUsers = new ArrayList<>(0);
    private List<GroupEntityImpl> groups = new ArrayList<>(0);
    private List<PostUserEntityImpl> posts = new ArrayList<>(0);
    private List<RoleEntityImpl> authorities = new ArrayList<>(0);
    private List<MusicEntityImpl> musics = new ArrayList<>(0);
    private List<VideoEntityImpl> videos = new ArrayList<>(0);
    private List<ImageEntityImpl> images = new ArrayList<>(0);

    @Column(name = "password")
    @Override
    public String getPassword() {
        return password;
    }

    @Override

    public void setPassword(String password) {
        this.password = password;
    }

    @Override

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    @Override

    public void setLogin(String login) {
        this.login = login;
    }

    @Override

    @Access(AccessType.PROPERTY)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<RoleEntityImpl> getAuthorities() {
        return authorities;
    }

    @Override

    public void setAuthorities(List<RoleEntityImpl> authorities) {
        this.authorities = authorities;
    }

    @Override

    @Access(AccessType.PROPERTY)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "friends", joinColumns = {
            @JoinColumn(name = "fk_user1", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_user2",
                    nullable = false, updatable = false)})
    public List<UserEntityImpl> getFriends() {
        return friends;
    }

    @Override

    public void setFriends(List<UserEntityImpl> friends) {
        this.friends = friends;
    }

    @Override

    @Access(AccessType.PROPERTY)
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public List<GroupEntityImpl> getGroups() {
        return groups;
    }

    @Override

    public void setGroups(List<GroupEntityImpl> groups) {
        this.groups = groups;
    }

    @Override

    @Access(AccessType.PROPERTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public List<PostUserEntityImpl> getPosts() {
        return posts;
    }

    @Override

    public void setPosts(List<PostUserEntityImpl> posts) {
        this.posts = posts;
    }

    @Override

    @Access(AccessType.PROPERTY)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "blacklist", joinColumns = {
            @JoinColumn(name = "fk_iduser", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_idblackuser",
                    nullable = false, updatable = false)})
    public List<UserEntityImpl> getBlackListUsers() {
        return blackListUsers;
    }

    @Override

    public void setBlackListUsers(List<UserEntityImpl> blackListUsers) {
        this.blackListUsers = blackListUsers;
    }

    @Override

    @Column(name = "enabled")
    public int getEnabled() {
        return enabled;
    }

    @Override

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Override

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Override

    public void setName(String name) {
        this.name = name;
    }

    @Override

    @Column(name = "lastname")
    public String getLastName() {
        return lastName;
    }

    @Override

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override

    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    @Override

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_media", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    public ImageEntityImpl getAvatar() {
        return avatar;
    }

    @Override

    public void setAvatar(ImageEntityImpl avatar) {
        this.avatar = avatar;
    }

    @Override

    @Column(name = "birthdate")
    public Date getBirthdate() {
        return birthdate;
    }

    @Override

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override

    public void setBirthdateString(String birthdate) {


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.birthdate = formatter.parse(birthdate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    @Override

    public void setCity(String city) {
        this.city = city;
    }

    @Override

    @Column(name = "about")
    public String getAbout() {
        return about;
    }

    @Override

    public void setAbout(String about) {
        this.about = about;
    }

    @Override

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Override

    public void setEmail(String email) {
        this.email = email;
    }

    @Override

    @Column(name = "skype")
    public String getSkype() {
        return skype;
    }

    @Override

    public void setSkype(String skype) {
        this.skype = skype;
    }

    @Override

    @Column(name = "mobile")
    public int getMobile() {
        return mobile;
    }

    @Override

    @Column(name = "mobile")
    public String getMobileString() {
        return Integer.toString(mobile);
    }

    @Override

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    @Override

    @Access(AccessType.PROPERTY)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "media_users", joinColumns = {
            @JoinColumn(name = "fk_users", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_media",
                    nullable = false, updatable = false)})
    public List<MusicEntityImpl> getMusics() {
        return musics;
    }

    @Override

    public void setMusics(List<MusicEntityImpl> musics) {
        this.musics = musics;
    }

    @Override

    @Access(AccessType.PROPERTY)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "media_users", joinColumns = {
            @JoinColumn(name = "fk_users", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_media",
                    nullable = false, updatable = false)})
    public List<VideoEntityImpl> getVideos() {
        return videos;
    }

    @Override

    public void setVideos(List<VideoEntityImpl> videos) {
        this.videos = videos;
    }

    @Override

    @Access(AccessType.PROPERTY)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "media_users", joinColumns = {
            @JoinColumn(name = "fk_users", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_media",
                    nullable = false, updatable = false)})
    public List<ImageEntityImpl> getImages() {
        return images;
    }

    @Override


    public void setImages(List<ImageEntityImpl> images) {
        this.images = images;
    }
}