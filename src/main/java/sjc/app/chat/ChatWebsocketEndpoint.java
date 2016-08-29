package sjc.app.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@ServerEndpoint(value = "/chat/{roomId}")
class ChatWebsocketEndpoint
{

    private static Logger logger = LoggerFactory.getLogger(ChatWebsocketEndpoint.class);
    private static String chatTag = "Chat: ";
    private static Map<Session, Long> sessionMap = new HashMap<>();


    @OnOpen
    public void open(@PathParam("roomId") Long roomId, Session session)
    {
        sessionMap.put(session, roomId);
        try
        {
            session.getBasicRemote().sendText("Connected to websocket dialog: " + roomId);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(final Session session, final String messageJson)
    {
        Long roomId = sessionMap.get(session);


        for (Map.Entry<Session, Long> sessionLongEntry : sessionMap.entrySet())
        {


            if (Objects.equals(sessionLongEntry.getValue(), roomId))
            {
                try
                {
                    sessionLongEntry.getKey().getBasicRemote().sendText(messageJson);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }

                logger.debug(chatTag + "session id: " + session.getId() + " send message: " + messageJson);

            }
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) throws IOException
    {
        Long roomId = sessionMap.get(session);
        for (Map.Entry<Session, Long> sessionLongEntry : sessionMap.entrySet())
        {


            if (Objects.equals(sessionLongEntry.getValue(), roomId))
            {
                sessionMap.remove(session);

                logger.debug(chatTag + reason.toString());

            }
        }

    }

    @OnError
    public void onError(Session session, Throwable ex)
    {

        Long roomId = sessionMap.get(session);
        for (Map.Entry<Session, Long> sessionLongEntry : sessionMap.entrySet())
        {


            if (Objects.equals(sessionLongEntry.getValue(), roomId))
            {

                sessionMap.remove(session);


            }
        }


    }


}
