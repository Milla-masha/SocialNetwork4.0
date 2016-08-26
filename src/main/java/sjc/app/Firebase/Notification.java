package sjc.app.firebase;

import sjc.app.constant.Constant;

public class Notification
{
    String title= Constant.TITLE;
    String body;

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
