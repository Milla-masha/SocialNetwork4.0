package sjc.app.model.entity;

import sjc.app.model.entity.impl.GroupEntityImpl;
import sjc.app.model.entity.impl.LikeEntityImpl;
import sjc.app.model.entity.impl.PostUser;

import java.util.List;

/**
 * Created by psycl on 29.07.2016.
 */
public interface PostEntity {

    public String getImage();

    public void setImage(String image);

    public String getAuthor();

    public void setAuthor(String  author);

    public String getText();

    public void setText(String text);

    public List<GroupEntityImpl> getGroupEntityImpls();

    public void setGroupEntityImpls(List<GroupEntityImpl> groupEntityImpls);

    public List<LikeEntityImpl> getLikes();

    public void setLikes(List<LikeEntityImpl> likes);

    public List<PostUser> getUsers();

    public void setUsers(List<PostUser> users);
}
