package sjc.app.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("MUSIC")
public class MusicEntityImpl extends MediaEntityImpl {

    private String name;
    private List<UserEntityImpl> users;

    public MusicEntityImpl() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany( fetch = FetchType.LAZY, mappedBy = "musics")
    public List<UserEntityImpl> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntityImpl> users) {
        this.users = users;
    }
}
