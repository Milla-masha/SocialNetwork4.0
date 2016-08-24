package sjc.app.chat.TomcatBaseWebsocket;


/**
 * Created by psycl on 23.08.2016.
 */

public class ChatMessage
{
    private String senderId;
    private String message;

    public String getSenderId()
    {
        return senderId;
    }

    public void setSenderId(String senderId)
    {
        this.senderId = senderId;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}