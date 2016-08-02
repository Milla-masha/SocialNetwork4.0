package sjc.app.model.entity;

import sjc.app.model.entity.impl.PostEntityImpl;
import sjc.app.model.entity.impl.UserEntityImpl;

/**
 * Created by psycl on 29.07.2016.
 */
public interface LikeEntity {
    public int getIsLike();

    public void setIsLike(int isLike);

    public PostEntityImpl getFkPost();

    public void setFkPost(PostEntityImpl fkPost);

    public UserEntityImpl getFkUser();

    public void setFkUser(UserEntityImpl fkUser);
}
