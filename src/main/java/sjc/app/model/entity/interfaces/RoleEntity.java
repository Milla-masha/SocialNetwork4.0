package sjc.app.model.entity.interfaces;

import sjc.app.model.entity.Role;
import sjc.app.model.entity.UserEntityImpl;

/**
 * Created by psycl on 09.08.2016.
 */
public interface RoleEntity {

    Role getRole();

    void setRole(Role role);

    UserEntityImpl getUser();

    void setUser(UserEntityImpl user);
}
