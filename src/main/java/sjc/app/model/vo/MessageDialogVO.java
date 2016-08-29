package sjc.app.model.vo;

import java.util.ArrayList;
import java.util.List;

public class MessageDialogVO
{
    private UserSmallVO owner;
    private List<UserSmallVO> reciver=new ArrayList<>(0);
    private List<MessageVO> messages=new ArrayList<>(0);

    public UserSmallVO getOwner()
    {
        return owner;
    }

    public void setOwner(UserSmallVO owner)
    {
        this.owner = owner;
    }

    public List<UserSmallVO> getReciver()
    {
        return reciver;
    }

    public void setReciver(List<UserSmallVO> reciver)
    {
        this.reciver = reciver;
    }

    public List<MessageVO> getMessages()
    {
        return messages;
    }

    public void setMessages(List<MessageVO> messages)
    {
        this.messages = messages;
    }
}
