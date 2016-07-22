package sjc.app.entity;

import javax.persistence.*;

/**
 * Created by Aleks69 on 19.07.2016.
 */

@Entity
@Table(name = "friends")
public class Friends extends AbstractPersistable {

    @JoinColumn(name = "fk_user1", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private RegisterUser friend1;

    @JoinColumn(name = "fk_user2", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private RegisterUser friend2;

    public RegisterUser getFriend1() {
        return friend1;
    }

    public void setFriend1(RegisterUser friend1) {
        this.friend1 = friend1;
    }

    public RegisterUser getFriend2() {
        return friend2;
    }

    public void setFriend2(RegisterUser friend2) {
        this.friend2 = friend2;
    }
}
