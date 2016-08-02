package sjc.app.model.entity;

import sjc.app.model.entity.impl.AuthoritiesImpl;
import sjc.app.model.entity.impl.UserEntityImpl;

import java.util.Date;
import java.util.List;

/**
 * Created by psycl on 29.07.2016.
 */


public interface UserEntity {
    public List<UserEntityImpl> getFriends();

    public void setFriends(List<UserEntityImpl> friends);

    public void setAuthorities(List<AuthoritiesImpl> authorities);

    public List<AuthoritiesImpl> getAuthorities();

    public void setLogin(String login);

    public String getLogin();

    public String getPassword();

    public void setPassword(String password);

    public String getName();

    public void setName(String name);

    public String getLastName();

    public void setLastName(String lastName);

    public Date getBirthday();

    public void setBirthday(Date birthday);

    public String getAvatar();

    public void setAvatar(String avatar);

    public String getCity();

    public void setCity(String city);

    public String getAbout();

    public void setAbout(String about);

    public String getSex();

    public void setSex(String sex);

    public String getMobile();

    public void setMobile(String mobile);

    public String getSkype();

    public void setSkype(String skype);

    public String getEmail();

    public void setEmail(String email);


}
