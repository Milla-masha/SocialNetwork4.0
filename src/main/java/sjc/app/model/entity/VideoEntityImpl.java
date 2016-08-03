package sjc.app.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("VIDEO")
public class VideoEntityImpl extends MediaEntityImpl {

    private String name;
    private String preview;
    private List<UserEntityImpl> users;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "preview")
    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany( fetch = FetchType.LAZY, mappedBy = "videos")
    public List<UserEntityImpl> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntityImpl> users) {
        this.users = users;
    }
}
