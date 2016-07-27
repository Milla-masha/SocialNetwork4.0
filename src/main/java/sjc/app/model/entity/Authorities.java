package sjc.app.model.entity;

import javax.persistence.*;


@Entity
@Table(name = "authorities")
public class Authorities extends AbstractPersistable {

    private String authorities;

    @JoinColumn(name = "idU", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity idU;

    @Column(name = "authorities")
    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public UserEntity getIdU() {
        return idU;
    }

    public void setIdU(UserEntity idU) {
        this.idU = idU;
    }
}
