package sjc.app.model.vo.impl;


import sjc.app.model.vo.IUserSmall;

public class UserSmallVO implements IUserSmall {

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


}
