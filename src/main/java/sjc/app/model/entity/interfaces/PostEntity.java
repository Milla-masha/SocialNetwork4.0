package sjc.app.model.entity.interfaces;

import sjc.app.model.entity.ImageEntityImpl;
import sjc.app.model.entity.LikeEntityImpl;

import java.util.Date;
import java.util.List;

public interface PostEntity {
    Date getDate();

    String getDateString();

    void setDate(Date date);

    ImageEntityImpl getImage();

    void setImage(ImageEntityImpl image);

    String getText();

    void setText(String text);

    List<LikeEntityImpl> getLikes();

    void setLikes(List<LikeEntityImpl> likes);
}
