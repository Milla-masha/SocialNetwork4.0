package sjc.app.model.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("IMAGE")
public class ImageEntityImpl extends MediaEntityImpl {

    private List<UserEntityImpl> users;

    @Access(AccessType.PROPERTY)
    @ManyToMany( fetch = FetchType.LAZY, mappedBy = "images")
    public List<UserEntityImpl> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntityImpl> users) {
        this.users = users;
    }
}
