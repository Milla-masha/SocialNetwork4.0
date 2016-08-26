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
    private List<SessionContainer> users = new ArrayList<>();

    public synchronized void join(Session session, Long roomId)
    {
        SessionContainer container = new SessionContainer(session, roomId);
        users.add(container);
    }

    public synchronized void leave(SessionContainer user)
    {
        users.remove(user);
    }

    public synchronized void sendMessage(JSONObject jsonObject, Long roomId) throws IOException
    {
        for (SessionContainer sess : users)
        {
            if (sess.getRoomId() == roomId)
            {
            sess.getSession().getBasicRemote().sendText(jsonObject.toString());
            }

        }
    }

}


