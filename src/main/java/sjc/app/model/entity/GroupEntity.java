package sjc.app.model.entity;

import sjc.app.model.entity.impl.PostEntityImpl;
import sjc.app.model.entity.impl.UserEntityImpl;

import java.util.List;

/**
 * Created by psycl on 29.07.2016.
 */
public interface GroupEntity {
    public String getName();

    public void setName(String name);

    public String getImage();

    public void setImage(String image);

    public String getDescription();

    public void setDescription(String description);

    public List<PostEntityImpl> getPosts();

    public void setPosts(List<PostEntityImpl> posts);

    public List<UserEntityImpl> getUsers();

    public void setUsers(List<UserEntityImpl> users);

}
