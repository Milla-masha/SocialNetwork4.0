package sjc.app.firebase;

public class Request
{
    private Notification notification = new Notification();

    private String to;

    public Notification getNotification()
    {
        return notification;
    }

    public void setBody(Object body)
    {
        this.notification.setBody(body);
    }
    public void setTitle(String title)
    {
        this.notification.setTitle(title);
    }
    public String getTo()
    {
        return to;
    }

    public void setTo(String to)
    {
        this.to = to;
    }
}
