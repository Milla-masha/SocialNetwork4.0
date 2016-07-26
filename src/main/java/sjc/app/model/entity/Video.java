package sjc.app.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "video")
public class Video extends AbstractPersistable{
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
    @Column(name = "preview")
    private String preview;
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne
    private UserEntity fkUser;

    public Video() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public UserEntity getFkUser() {
        return fkUser;
    }

    public void setFkUser(UserEntity fkUser) {
        this.fkUser = fkUser;
    }
}
