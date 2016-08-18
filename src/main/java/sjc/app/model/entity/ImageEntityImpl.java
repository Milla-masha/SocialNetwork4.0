package sjc.app.model.entity;


import sjc.app.model.entity.interfaces.ImageEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("IMAGE")
public class ImageEntityImpl extends MediaEntityImpl implements ImageEntity {

    private List<UserEntityImpl> users=new ArrayList<>(0);

    public ImageEntityImpl() {
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany( fetch = FetchType.LAZY, mappedBy = "images", cascade = CascadeType.ALL)
    @Override
    public List<UserEntityImpl> getUsers() {
        return users;
    }
    @Override
    public void setUsers(List<UserEntityImpl> users) {
        this.users = users;
    }
}
