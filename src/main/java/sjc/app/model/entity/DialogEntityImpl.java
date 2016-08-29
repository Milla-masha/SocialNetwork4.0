
package sjc.app.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "dialogs")
public class DialogEntityImpl extends AbstractPersistable
{

    private List<MessageEntityImpl> messages = new ArrayList<>(0);
    private List<UserEntityImpl> users = new ArrayList<>(0);

    @Access(AccessType.PROPERTY)
    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<MessageEntityImpl> getMessages()
    {
        return messages;
    }

    public void setMessages(List<MessageEntityImpl> messages)
    {
        this.messages = messages;
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_dialog", joinColumns = {
            @JoinColumn(name = "fk_dialog", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "fk_user",
                    nullable = false, updatable = false)})
    public List<UserEntityImpl> getUsers()
    {
        return users;
    }

    public void setUsers(List<UserEntityImpl> users)
    {
        this.users = users;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DialogEntityImpl that = (DialogEntityImpl) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;

    }

    @Override
    public int hashCode()
    {
        return getId() != null ? getId().hashCode() : 0;
    }
}