package sjc.app.model.entity.impl;

import sjc.app.model.entity.MusicEntity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "music")
public class MusicEntityImpl extends AbstractPersistable implements MusicEntity {

    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @OneToOne(optional = false,fetch = FetchType.LAZY)
    private UserEntityImpl user;

    public MusicEntityImpl() {
    }

    @Column(name = "url")
    private String url;

    @Column(name = "name")
    private String name;

    @Column(name = "time")
    private Time time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntityImpl getUser() {
        return user;
    }

    public void setUser(UserEntityImpl user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
