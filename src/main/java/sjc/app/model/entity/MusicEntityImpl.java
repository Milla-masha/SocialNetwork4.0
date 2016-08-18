package sjc.app.model.entity;

import sjc.app.model.entity.interfaces.MusicEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("MUSIC")
public class MusicEntityImpl extends MediaEntityImpl implements MusicEntity {

    private String name;
    private List<UserEntityImpl> users=new ArrayList<>(0);

    public MusicEntityImpl() {
    }

    @Column(name = "name")
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany( fetch = FetchType.LAZY, mappedBy = "musics")
    @Override
    public List<UserEntityImpl> getUsers() {
        return users;
    }
    @Override
    public void setUsers(List<UserEntityImpl> users) {
        this.users = users;
    }
}
