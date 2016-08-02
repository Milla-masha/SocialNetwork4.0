package sjc.app.model.entity.impl;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "group_user")
public class GroupUser extends AbstractPersistable {
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserEntityImpl fkUser;
    @JoinColumn(name = "fk_group", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GroupEntityImpl fkGroupEntityImpl;

    public GroupUser() {
    }

    public UserEntityImpl getFkUser() {
        return fkUser;
    }

    public void setFkUser(UserEntityImpl fkUser) {
        this.fkUser = fkUser;
    }

    public GroupEntityImpl getFkGroupEntityImpl() {
        return fkGroupEntityImpl;
    }

    public void setFkGroupEntityImpl(GroupEntityImpl fkGroupEntityImpl) {
        this.fkGroupEntityImpl = fkGroupEntityImpl;
    }
}
