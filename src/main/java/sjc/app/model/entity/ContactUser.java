package sjc.app.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "contact_user")
public class ContactUser extends AbstractPersistable {

    @JoinColumn(name = "fk_registeruser", referencedColumnName = "id")
    @OneToOne(optional = false,fetch = FetchType.LAZY)
    private RegisterUser registerUser;

    public RegisterUser getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    @Column(name = "mobile")
    private String mobile;

    public ContactUser() {
    }

    @Column(name = "skype")
    private String skype;

    @Column(name = "email")
    private String email;


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
