package sjc.app.model.vo;


import sjc.app.model.vo.impl.UserSmallVO;

public interface IPost
{
    UserSmallVO getOwner();

    void setOwner(UserSmallVO owner);

    String getImage();

    void setImage(String image);

    String getText();

    void setText(String text);

    Integer getLike();

    void setLike(Integer like);

    Integer getDislike();

    void setDislike(Integer dislike);
    }

