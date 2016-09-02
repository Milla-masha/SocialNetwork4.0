package sjc.app.chat;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.server.standard.SpringConfigurator;
import sjc.app.model.vo.MessageVO;
import sjc.app.rest.exception.NotFoundExseption;
import sjc.app.service.MessageService;
import sjc.app.service.impl.OnlineUser;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ServerEndpoint(value = "/chat/{roomId}/{accessToken}", configurator = SpringConfigurator.class)
public class ChatWebsocketEndpoint
{
    @Autowired
    private MessageService messageService;
    @Autowired
    private OnlineUser onlineUser;
    // private static Logger logger = LoggerFactory.getLogger(ChatWebsocketEndpoint.class);
    // private static String chatTag = "Chat: ";
    private static Map<Session, Long> sessionMap = new HashMap<>();

    @OnOpen
    public void open(@PathParam("roomId") Long roomId, @PathParam("accessToken") String accessToken, Session session)
    {


        if (onlineUser.isAuthorize(accessToken))
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
        else return;
    }

    @OnMessage
    public void onMessage(final Session session, final String messageJson) throws NotFoundExseption
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
                }
                // logger.debug(chatTag + messageJson);
            }
        }
        Gson gson = new Gson();
        MessageVO messageVO = gson.fromJson(messageJson, MessageVO.class);
        messageService.addMessage(messageVO.getMessage(), messageVO.getSenderId(), roomId);
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
