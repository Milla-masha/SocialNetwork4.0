/*
package sjc.app.model.entity;

import sjc.app.model.entity.interfaces.ChatMessageEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "messages")
public class ChatMessageEntityImpl extends AbstractPersistable implements ChatMessageEntity
{


    private String message;
    private Date date;
    private List<DialogEntityImpl> dialogs;



    @Column(name = "message_text")
    @Override
    public String getMessage()
    {
        return message;
    }

    @Override
    public void setMessage(String message)
    {
        this.message = message;
    }
    @Column(name = "date")
    @Override
    public Date getDate()
    {
        return date;
    }

    @Override
    public void setDate(Date date)
    {
        this.date = date;
    }

    @JoinColumn(name = "fk_dialog_id",  referencedColumnName = "id")
    @OneToMany(fetch = FetchType.LAZY, cascade =  {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH})
    @Override
    public List<DialogEntityImpl> getDialogs()
    {
        return dialogs;
    }
    @Override
    public void setDialogs(List<DialogEntityImpl> dialogs)
    {
        this.dialogs = dialogs;
    }


}
*/
