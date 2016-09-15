package sjc.app.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.server.standard.SpringConfigurator;
import sjc.app.service.impl.OnlineUser;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by psycl on 15.09.2016.
 */
@ServerEndpoint(value = "/notification/{userId}/{accessToken}", configurator = SpringConfigurator.class)
public class NotificationWebsocketEndpoint
{

    @Autowired
    private OnlineUser onlineUser;
    private static Map<Session, Long> sessionMap = new HashMap<>();

    @OnOpen
    public void open(@PathParam("userId") Long userId, @PathParam("accessToken") String accessToken, Session session)
    {
        if (onlineUser.isAuthorize(accessToken))
        {
            sessionMap.put(session, userId);
        } else return;
    }

    public static void notificationSender(Long idUser, Object object)
    {
        for (Map.Entry<Session, Long> sessionLongEntry : sessionMap.entrySet())
        {
            if (Objects.equals(sessionLongEntry.getValue(), idUser))
            {
                try
                {
                    sessionLongEntry.getKey().getBasicRemote().sendText(object.toString());
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
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

                //logger.debug(chatTag + reason.toString());

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
