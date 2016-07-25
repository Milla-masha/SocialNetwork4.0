package sjc.app.repository.vo.impl;

import sjc.app.repository.vo.IGroup;

public class GroupVO implements IGroup
{

    String name;
    Integer folowers;
    String image;

    public GroupVO() {
    }

    public GroupVO(String name, Integer folowers, String image) {
        this.name = name;
        this.folowers = folowers;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFolowers() {
        return folowers;
    }

    public void setFolowers(Integer folowers) {
        this.folowers = folowers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
