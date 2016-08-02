package sjc.app.model.entity.impl;

import sjc.app.model.entity.VideoEntity;

import javax.persistence.*;

@Entity
@Table(name = "video")
public class VideoEntityImpl extends AbstractPersistable implements VideoEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
    @Column(name = "preview")
    private String preview;
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne
    private UserEntityImpl fkUser;

    public VideoEntityImpl() {
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

    public UserEntityImpl getFkUser() {
        return fkUser;
    }

    public void setFkUser(UserEntityImpl fkUser) {
        this.fkUser = fkUser;
    }
}
