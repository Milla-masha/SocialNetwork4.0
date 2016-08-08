package sjc.app.model.entity.interfaces;

import sjc.app.model.entity.UserEntityImpl;

import java.util.List;

/**
 * Created by psycl on 09.08.2016.
 */
public interface MusicEntity {
    String getName();

    void setName(String name);

    List<UserEntityImpl> getUsers();

    void setUsers(List<UserEntityImpl> users);
}
