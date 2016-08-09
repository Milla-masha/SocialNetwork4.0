package sjc.app.model.entity.interfaces;

import sjc.app.model.entity.ImageEntityImpl;
import sjc.app.model.entity.PostGroupEntityImpl;
import sjc.app.model.entity.UserEntityImpl;

import java.util.List;

public interface GroupEntity {

    String getName();

    void setName(String name);

    ImageEntityImpl getImage();

    void setImage(ImageEntityImpl image);

    String getDescription();

    void setDescription(String description);

    List<UserEntityImpl> getUsers();

    void setUsers(List<UserEntityImpl> users);

    List<PostGroupEntityImpl> getPosts();

    void setPosts(List<PostGroupEntityImpl> posts);

    UserEntityImpl getOwner();

    void setOwner(UserEntityImpl owner);
}
