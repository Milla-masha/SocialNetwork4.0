package sjc.app.model.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "messages")
public class MessageEntityImpl extends AbstractPersistable
{
    private String text;
    private Date date;
    private DialogEntityImpl dialog;

    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private UserEntityImpl sender;

    @Access(AccessType.PROPERTY)
    @Column(name = "text")
    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    @Access(AccessType.PROPERTY)
    @Column(name = "date")
    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public UserEntityImpl getSender()
    {
        return sender;
    }

    public void setSender(UserEntityImpl sender)
    {
        this.sender = sender;
    }

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "fk_dialog", referencedColumnName = "id")
    @ManyToOne(optional = false)
    public DialogEntityImpl getDialog()
    {
        return dialog;
    }

    public void setDialog(DialogEntityImpl dialog)
    {
        this.dialog = dialog;
    }
}
