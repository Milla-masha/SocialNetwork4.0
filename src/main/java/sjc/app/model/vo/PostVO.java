package sjc.app.model.vo;

public class PostVO {

    UserSmallVO owner;
    String image;
    String text;
    Integer like;
    Integer dislike;
    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PostVO() {
    }

    public UserSmallVO getOwner() {
        return owner;
    }

    public void setOwner(UserSmallVO owner) {
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
