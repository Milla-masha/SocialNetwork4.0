package sjc.app.model.vo;

public class MessageVO extends BaseVO
{
    private String message;
    private Long senderId;

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
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
