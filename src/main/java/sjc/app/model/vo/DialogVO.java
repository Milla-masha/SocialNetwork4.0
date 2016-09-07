package sjc.app.model.vo;

import java.util.List;

public class DialogVO extends BaseVO
{
    private MessageVO lastMessage;
    private List<UserSmallVO> reciver;

    public MessageVO getLastMessage()
    {
        return lastMessage;
    }

    public void setLastMessage(MessageVO lastMessage)
    {
        this.lastMessage = lastMessage;
    }

    public List<UserSmallVO> getReciver()
    {
        return reciver;
    }

    public void setReciver(List<UserSmallVO> reciver)
    {
        this.reciver = reciver;
    }
}
