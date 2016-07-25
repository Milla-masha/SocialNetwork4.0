package sjc.app.repository.vo;
import sjc.app.repository.vo.impl.SmallUserVO;

public interface IPost
{
    SmallUserVO getOwner();

    void setOwner(SmallUserVO owner);

    String getImage();

    void setImage(String image);

    String getText();

    void setText(String text);

    Integer getLike();

    void setLike(Integer like);

    Integer getDislike();

    void setDislike(Integer dislike);
    }

