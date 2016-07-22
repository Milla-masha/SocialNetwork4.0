package sjc.app.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contact_user")
public class ContactUser extends AbstractPersistable {

    @JoinColumn(name = "fk_info_user", referencedColumnName = "id")
    @OneToOne(optional = false,fetch = FetchType.LAZY)
    private InfoUser infoUser;

    @Column(name = "mobile")
    private String mobile;

    public ContactUser() {
    }

    @Column(name = "skype")
    private String skype;

    @Column(name = "email")
    private String email;

    public InfoUser getInfoUser() {
        return infoUser;
    }

    public void setInfoUser(InfoUser infoUser) {
        this.infoUser = infoUser;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
