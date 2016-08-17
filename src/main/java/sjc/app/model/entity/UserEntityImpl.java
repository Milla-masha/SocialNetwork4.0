package sjc.app.model.entity;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntityImpl extends AbstractPersistable
{

    private String password;
    private String login;
    private String name;
    private String email;
    private String skype;
    private String mobile;
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
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Column(name = "login")
    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    @Access(AccessType.PROPERTY)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<RoleEntityImpl> getAuthorities()
    {
        return authorities;
    }

    public void setAuthorities(List<RoleEntityImpl> authorities)
    {
        this.authorities = authorities;
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "friends", joinColumns = {
            @JoinColumn(name = "fk_user1", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_user2",
                    nullable = false, updatable = false)})
    public List<UserEntityImpl> getFriends()
    {
        return friends;
    }

    public void setFriends(List<UserEntityImpl> friends)
    {
        this.friends = friends;
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public List<GroupEntityImpl> getGroups()
    {
        return groups;
    }

    public void setGroups(List<GroupEntityImpl> groups)
    {
        this.groups = groups;
    }

    @Access(AccessType.PROPERTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public List<PostUserEntityImpl> getPosts()
    {
        return posts;
    }

    public void setPosts(List<PostUserEntityImpl> posts)
    {
        this.posts = posts;
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "blacklist", joinColumns = {
            @JoinColumn(name = "fk_iduser", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_idblackuser",
                    nullable = false, updatable = false)})
    public List<UserEntityImpl> getBlackListUsers()
    {
        return blackListUsers;
    }

    public void setBlackListUsers(List<UserEntityImpl> blackListUsers)
    {
        this.blackListUsers = blackListUsers;
    }

    @Column(name = "enabled")
    public int getEnabled()
    {
        return enabled;
    }

    public void setEnabled(int enabled)
    {
        this.enabled = enabled;
    }

    @Column(name = "name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Column(name = "lastname")
    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Column(name = "sex")
    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_media", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    public ImageEntityImpl getAvatar()
    {
        return avatar;
    }

    public void setAvatar(ImageEntityImpl avatar)
    {
        this.avatar = avatar;
    }

    @Column(name = "birthdate")
    public Date getBirthdate()
    {
        return birthdate;
    }

    @Column(name = "birthdate")
    public String getBirthdateString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(birthdate);
    }

    public void setBirthdate(Date birthdate)
    {
        this.birthdate = birthdate;
    }

    public void setBirthdateString(String birthdate)
    {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            this.birthdate = formatter.parse(birthdate);

        } catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    @Column(name = "city")
    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    @Column(name = "about")
    public String getAbout()
    {
        return about;
    }

    public void setAbout(String about)
    {
        this.about = about;
    }

    @Column(name = "email")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Column(name = "skype")
    public String getSkype()
    {
        return skype;
    }

    public void setSkype(String skype)
    {
        this.skype = skype;
    }

    @Column(name = "mobile")
    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "media_users", joinColumns = {
            @JoinColumn(name = "fk_users", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_media",
                    nullable = false, updatable = false)})
    public List<MusicEntityImpl> getMusics()
    {
        return musics;
    }

    public void setMusics(List<MusicEntityImpl> musics)
    {
        this.musics = musics;
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "media_users", joinColumns = {
            @JoinColumn(name = "fk_users", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_media",
                    nullable = false, updatable = false)})
    public List<VideoEntityImpl> getVideos()
    {
        return videos;
    }

    public void setVideos(List<VideoEntityImpl> videos)
    {
        this.videos = videos;
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "media_users", joinColumns = {
            @JoinColumn(name = "fk_users", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_media",
                    nullable = false, updatable = false)})
    public List<ImageEntityImpl> getImages()
    {
        return images;
    }

    public void setImages(List<ImageEntityImpl> images)
    {
        this.images = images;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntityImpl that = (UserEntityImpl) o;

        return login != null ? login.equals(that.login) : that.login == null;

    }

    @Override
    public int hashCode()
    {
        return login != null ? login.hashCode() : 0;
    }
}