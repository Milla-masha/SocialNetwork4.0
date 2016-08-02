package sjc.app.model.entity;

import sjc.app.model.entity.impl.UserEntityImpl;

/**
 * Created by psycl on 29.07.2016.
 */
public interface FriendsEntity {
    public int getStatus();

    public void setStatus(int status);


    public UserEntityImpl getFriend1();

    public void setFriend1(UserEntityImpl friend1) ;

    public UserEntityImpl getFriend2();

    public void setFriend2(UserEntityImpl friend2);
}
