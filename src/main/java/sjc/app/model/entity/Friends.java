package sjc.app.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class Friends extends AbstractPersistable {

    @JoinColumn(name = "fk_user1", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity friend1;

    @JoinColumn(name = "fk_user2", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity friend2;

    public UserEntity getFriend1() {
        return friend1;
    }

    public void setFriend1(UserEntity friend1) {
        this.friend1 = friend1;
    }

    public UserEntity getFriend2() {
        return friend2;
    }

    public void setFriend2(UserEntity friend2) {
        this.friend2 = friend2;
    }
}
