package sjc.app.model.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "music")
public class Music extends AbstractPersistable {

    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @OneToOne(optional = false,fetch = FetchType.LAZY)
    private RegisterUser user;

    public Music() {
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

    public RegisterUser getUser() {
        return user;
    }

    public void setUser(RegisterUser user) {
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
