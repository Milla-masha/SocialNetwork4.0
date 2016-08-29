package sjc.app.model.vo;

import java.util.List;

public class DialogVO extends BaseVO
{
    private String lastMessage;
    private List<UserSmallVO> reciver;

    public String getLastMessage()
    {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage)
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
