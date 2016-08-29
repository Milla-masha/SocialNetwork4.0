package sjc.app.model.vo;

public class MessageVO extends BaseVO
{
    private String text;
    private Long senderId;

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public Long getSenderId()
    {
        return senderId;
    }

    public void setSenderId(Long senderId)
    {
        this.senderId = senderId;
    }
}
