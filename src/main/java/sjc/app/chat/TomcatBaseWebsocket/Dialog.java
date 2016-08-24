package sjc.app.chat.TomcatBaseWebsocket;


import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by psycl on 23.08.2016.
 */

@Service
public class Dialog
{

    private static Dialog instance = null;
    private List<Session> sessions = new ArrayList<Session>();

    public synchronized void join(Session session)
    {
        sessions.add(session);
    }

    public synchronized void leave(Session session)
    {
        sessions.remove(session);
    }

    public synchronized void sendMessage(JSONObject jsonObject)
    {
        for (Session session : sessions)
        {
            if (session.isOpen())
            {
                try
                {
                    session.getBasicRemote().sendText(jsonObject.toString());

                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized static Dialog getDialog()
    {
        if (instance == null)
        {
            instance = new Dialog();
        }
        return instance;
    }
}

