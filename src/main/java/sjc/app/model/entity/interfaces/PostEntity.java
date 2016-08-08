package sjc.app.model.entity.interfaces;

import sjc.app.model.entity.ImageEntityImpl;
import sjc.app.model.entity.LikeEntityImpl;

import java.util.List;

/**
 * Created by psycl on 09.08.2016.
 */
public interface PostEntity {
    ImageEntityImpl getImage();

    void setImage(ImageEntityImpl image);

    String getText();

    void setText(String text);

    List<LikeEntityImpl> getLikes();

    void setLikes(List<LikeEntityImpl> likes);
}
