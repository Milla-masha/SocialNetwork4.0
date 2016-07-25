package sjc.app.repository.vo.impl;

import sjc.app.repository.vo.IPost;

public class PostVO implements IPost{

    SmallUserVO owner;
    String image;
    String text;
    Integer like;
    Integer dislike;

    public PostVO() {
    }

    public PostVO(SmallUserVO owner, String image, String text, Integer like, Integer dislike) {
        this.owner = owner;
        this.image = image;
        this.text = text;
        this.like = like;
        this.dislike = dislike;
    }

    public SmallUserVO getOwner() {
        return owner;
    }

    public void setOwner(SmallUserVO owner) {
        this.owner = owner;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getDislike() {
        return dislike;
    }

    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }
}
