package sjc.app.model.entity;

import sjc.app.model.entity.impl.UserEntityImpl;

import java.sql.Time;

/**
 * Created by psycl on 29.07.2016.
 */
public interface MusicEntity {

    public String getName();

    public void setName(String name);

    public UserEntityImpl getUser();

    public void setUser(UserEntityImpl user);

    public String getUrl();

    public void setUrl(String url);

    public Time getTime();

    public void setTime(Time time);

}
