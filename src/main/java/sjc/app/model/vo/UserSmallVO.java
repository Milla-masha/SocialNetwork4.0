package sjc.app.model.vo;


public class UserSmallVO {

    Long idUser;
    String name;
    String lastName;
    String avatar;

    public UserSmallVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getIdUser()
    {
        return idUser;
    }

    public void setIdUser(Long idUser)
    {
        this.idUser = idUser;
    }
}
