package sjc.app.model.entity;

import sjc.app.model.entity.impl.UserEntityImpl;

/**
 * Created by psycl on 29.07.2016.
 */
public interface Authorities {
    public String getAuthorities();
    public void setAuthorities(String authorities);
    public UserEntityImpl getUserId();
    public void setUserId(UserEntityImpl userId);
}
