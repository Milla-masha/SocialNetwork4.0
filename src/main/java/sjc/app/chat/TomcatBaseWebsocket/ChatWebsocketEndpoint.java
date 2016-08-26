package sjc.app.chat.TomcatBaseWebsocket;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import sjc.app.repository.dao.UserDao;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by psycl on 24.08.2016.
 */
@ServerEndpoint(value = "/chat/{roomId}" )
public class ChatWebsocketEndpoint
{
    private volatile String roomId;
    @Autowired
    Dialog dialog = new Dialog();

    @Autowired
    UserDao userDao;

    private Logger log;

    private String sessionId;

    @OnOpen
    public void open(@PathParam("roomId")Long roomId, Session session)
    {
        this.roomId = roomId.toString();
        try
        {
            dialog.join(session, roomId);


            session.getBasicRemote().sendText("Connected to websocket dialog: "+ roomId);
            session.getBasicRemote().sendText(sessionId);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(final Session session, final String messageJson) throws IOException
    {
        JSONObject jsonObject = new JSONObject(messageJson);
        dialog.sendMessage(jsonObject, Long.parseLong(roomId));

    }

    @OnClose
    public void onClose(Session session, CloseReason reason)
    {
    }

    @OnError
    public void onError(Session session, Throwable ex)
    {
        log.info("Error: " + ex.getMessage());
    }
}