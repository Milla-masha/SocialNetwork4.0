package sjc.app.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "group_user")
public class GroupUser extends AbstractPersistable {
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RegisterUser fkUser;
    @JoinColumn(name = "fk_group", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Group fkGroup;

    public GroupUser() {
    }

    public RegisterUser getFkUser() {
        return fkUser;
    }

    public void setFkUser(RegisterUser fkUser) {
        this.fkUser = fkUser;
    }

    public Group getFkGroup() {
        return fkGroup;
    }

    public void setFkGroup(Group fkGroup) {
        this.fkGroup = fkGroup;
    }
}
