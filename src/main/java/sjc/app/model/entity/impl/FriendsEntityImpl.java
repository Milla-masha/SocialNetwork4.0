package sjc.app.model.entity.impl;

import sjc.app.model.entity.FriendsEntity;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class FriendsEntityImpl extends AbstractPersistable implements FriendsEntity {

    @JoinColumn(name = "fk_user1", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntityImpl friend1;

    @JoinColumn(name = "fk_user2", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntityImpl friend2;

    @Column(name = "status")
    private int status;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public UserEntityImpl getFriend1() {
        return friend1;
    }

    public void setFriend1(UserEntityImpl friend1) {
        this.friend1 = friend1;
    }

    public UserEntityImpl getFriend2() {
        return friend2;
    }

    public void setFriend2(UserEntityImpl friend2) {
        this.friend2 = friend2;
    }
}
