/*
package sjc.app.model.entity;

import sjc.app.model.entity.interfaces.DialogEntity;

import javax.persistence.*;


@Entity
@Table(name = "dialogs")
public class DialogEntityImpl extends AbstractPersistable implements DialogEntity
{
    private Long dialogId;
    private UserEntityImpl sender;


    @Column(name = "id")
    @Override
    public Long getDialogId()
    {
        return dialogId;
    }
    @Override
    public void setDialogId(Long dialogId)
    {
        this.dialogId = dialogId;
    }

    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "sender_id",referencedColumnName = "id" )
    @ManyToOne(fetch = FetchType.LAZY, cascade =  {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH})
    @Override
    public UserEntityImpl getSender()
    {
        return sender;
    }
    @Override
    public void setSender(UserEntityImpl sender)
    {
        this.sender = sender;
    }



}
*/
