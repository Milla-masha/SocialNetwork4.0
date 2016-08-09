package sjc.app.model.entity.interfaces;

import sjc.app.model.entity.UserEntityImpl;

/**
 * Created by psycl on 09.08.2016.
 */
public interface PostUserEntity {

    UserEntityImpl getUser();

    void setUser(UserEntityImpl user);
}
