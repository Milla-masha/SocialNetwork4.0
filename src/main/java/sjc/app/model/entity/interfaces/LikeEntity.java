package sjc.app.model.entity.interfaces;

import sjc.app.model.entity.PostEntityImpl;
import sjc.app.model.entity.UserEntityImpl;

/**
 * Created by psycl on 09.08.2016.
 */
public interface LikeEntity {
    int getIsLike();

    void setIsLike(int isLike);

    PostEntityImpl getFkPost();

    void setFkPost(PostEntityImpl fkPost);

    UserEntityImpl getFkUser();

    void setFkUser(UserEntityImpl fkUser);
}
