package sjc.app.repository.vo.impl;


import sjc.app.repository.vo.ISmallUser;

public class SmallUserVO implements ISmallUser{

    String name;
    String lastName;
    String avatar;

    public SmallUserVO() {
    }

    public SmallUserVO(String name, String lastName, String avatar) {
        this.name = name;
        this.lastName = lastName;
        this.avatar = avatar;
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
